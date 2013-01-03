package jp.myapp.service;

import java.sql.Timestamp;

import jp.myapp.bean.UserInfo;
import jp.myapp.dao.entity.AuthoritiesImpl;
import jp.myapp.dao.entity.Users;
import jp.myapp.dao.mapper.AuthoritiesMapper;
import jp.myapp.dao.mapper.UsersMapper;
import jp.myapp.dao.util.OptimisticLockControl;
import jp.myapp.exception.ApplicationException;
import jp.myapp.exception.BusinessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private AuthoritiesMapper authoritiesMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserInfo loginUser(String userId, String password) throws ApplicationException {

        // ユーザ情報データを取得する
        Users source = this.usersMapper.selectForUpdate(userId);

        if (source == null || source.getPassword() == null) {
            throw new BusinessException("Error.NotMatchUserIdOrPassword", true);
        }

        UserInfo userInfo = new UserInfo(source);

        // パスワードのハッシュ値との一致チェックを行う
        boolean passwordValid = this.passwordEncoder.isPasswordValid(
                userInfo.getPassword(), password, userInfo.getSalt());
        if (!passwordValid) {
            throw new BusinessException("Error.NotMatchUserIdOrPassword", true);
        }

        // ユーザの有効チェックを行う
        if (!userInfo.isValid()) {
            // 無効ユーザの削除を行う
            this.authoritiesMapper.deleteByUserId(source.getUserId());
            (new OptimisticLockControl<>(this.usersMapper)).delete(source);
            throw new ApplicationException("Error.UserInvalid", true);
        }

        return userInfo;
    }

    @Override
    @Transactional
    public void registerUser(String userId, String userName, String password) {

        if (this.usersMapper.select(userId) != null) {
            throw new BusinessException("Error.UserExists", true);
        }

        UserInfo usersEntity = new UserInfo();
        Timestamp current = new Timestamp(System.currentTimeMillis());

        usersEntity.setUserId(userId);
        usersEntity.setUsername(userName);
        usersEntity.setPasswordUpdatedDatetime(current);
        usersEntity.setEnabled(true);
        usersEntity.setProvisionalRegistration(true);
        usersEntity.setLastLogin(null);
        usersEntity.setRegisterDatetime(current);
        usersEntity.setRegisterUserId(userId);
        usersEntity.setUpdatedDatetime(current);
        usersEntity.setUpdatedUserId(userId);
        usersEntity.setVersion(0);
        usersEntity.setPassword(this.passwordEncoder.encodePassword(password, usersEntity.getSalt()));

        this.usersMapper.insert(usersEntity);

        AuthoritiesImpl authoritiesEntity = new AuthoritiesImpl();

        authoritiesEntity.setUserId(userId);
        authoritiesEntity.setAuthority("ROLE_USER");
        authoritiesEntity.setRegisterDatetime(current);
        authoritiesEntity.setRegisterUserId(userId);
        authoritiesEntity.setUpdatedDatetime(current);
        authoritiesEntity.setUpdatedUserId(userId);
        authoritiesEntity.setVersion(0);

        this.authoritiesMapper.insert(authoritiesEntity);
    }
}
