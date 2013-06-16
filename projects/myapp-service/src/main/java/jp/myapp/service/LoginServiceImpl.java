package jp.myapp.service;

import java.sql.Timestamp;

import jp.myapp.bean.UserInfoUtil;
import jp.myapp.data.entity.management.Authorities;
import jp.myapp.data.entity.management.Users;
import jp.myapp.data.mapper.management.AuthoritiesMapper;
import jp.myapp.data.mapper.management.UsersMapper;
import jp.myapp.data.support.OptimisticLockControl;
import jp.myapp.exception.ApplicationException;
import jp.myapp.exception.BusinessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    public Users loginUser(String userId, String password) throws ApplicationException {

        // ユーザ情報データを取得する
        Users user = this.usersMapper.selectForUpdate(userId);

        if (user == null || user.getPassword() == null) {
            throw new BusinessException("Error.NotMatchUserIdOrPassword", true);
        }

        // パスワードのハッシュ値との一致チェックを行う
        boolean passwordValid = this.passwordEncoder.matches(password, user.getPassword());
        if (!passwordValid) {
            throw new BusinessException("Error.NotMatchUserIdOrPassword", true);
        }

        // ユーザの有効チェックを行う
        if (!UserInfoUtil.isValid(user)) {
            // 無効ユーザの削除を行う
            this.authoritiesMapper.deleteByUserId(user.getUserId());
            (new OptimisticLockControl<>(this.usersMapper)).delete(user);
            throw new ApplicationException("Error.UserInvalid", true);
        }

        return user;
    }

    @Override
    @Transactional
    public void registerUser(String userId, String userName, String password) {

        if (this.usersMapper.select(userId) != null) {
            throw new BusinessException("Error.UserExists", true);
        }

        Users usersEntity = new Users();
        Timestamp current = new Timestamp(System.currentTimeMillis());

        usersEntity.setUserId(userId);
        usersEntity.setUsername(userName);
        usersEntity.setPassword(this.passwordEncoder.encode(password));
        usersEntity.setPasswordUpdatedTimestamp(current);
        usersEntity.setEnabled(Boolean.TRUE);
        usersEntity.setInterimRegister(Boolean.TRUE);
        usersEntity.setLoginErrorCount(0);
        usersEntity.setLockoutTimestamp(null);
        usersEntity.setLastLoginTimestamp(null);
        usersEntity.setLogoutTimestamp(null);
        usersEntity.setRegisterTimestamp(current);
        usersEntity.setRegisterUserId(userId);
        usersEntity.setUpdatedTimestamp(current);
        usersEntity.setUpdatedUserId(userId);
        usersEntity.setVersion(0);

        this.usersMapper.insert(usersEntity);

        Authorities authoritiesEntity = new Authorities();

        authoritiesEntity.setUserId(userId);
        authoritiesEntity.setAuthority("ROLE_USER");
        authoritiesEntity.setRegisterTimestamp(current);
        authoritiesEntity.setRegisterUserId(userId);
        authoritiesEntity.setUpdatedTimestamp(current);
        authoritiesEntity.setUpdatedUserId(userId);
        authoritiesEntity.setVersion(0);

        this.authoritiesMapper.insert(authoritiesEntity);
    }
}
