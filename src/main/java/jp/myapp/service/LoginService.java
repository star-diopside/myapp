package jp.myapp.service;

import java.sql.Timestamp;

import jp.myapp.bean.UserInfo;
import jp.myapp.dao.entity.AuthoritiesImpl;
import jp.myapp.dao.entity.Users;
import jp.myapp.dao.entity.UsersImpl;
import jp.myapp.dao.mapper.AuthoritiesMapper;
import jp.myapp.dao.mapper.UsersMapper;
import jp.myapp.dao.util.OptimisticLockControl;
import jp.myapp.exception.ApplicationException;
import jp.myapp.exception.NoRollbackApplicationException;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private AuthoritiesMapper authoritiesMapper;

    @Transactional(rollbackFor = Throwable.class, noRollbackFor = NoRollbackApplicationException.class)
    public UserInfo loginUser(String userId, String password) throws ApplicationException {

        // ユーザ情報データを取得する
        Users source = this.usersMapper.selectForUpdate(userId);

        if (source == null || source.getPassword() == null) {
            throw new ApplicationException("Error.NotMatchUserIdOrPassword", true);
        }

        UserInfo userInfo = new UserInfo(source);

        // パスワードのハッシュ値との一致チェックを行う
        String passwordDigest = DigestUtils.sha256Hex(password);
        if (!passwordDigest.equals(userInfo.getPassword().trim())) {
            throw new ApplicationException("Error.NotMatchUserIdOrPassword", true);
        }

        // ユーザの有効チェックを行う
        if (!userInfo.isValidity()) {
            // 無効ユーザの削除を行う
            this.authoritiesMapper.deleteByUserId(source.getUserId());
            (new OptimisticLockControl<>(this.usersMapper)).delete(source);
            throw new NoRollbackApplicationException("Error.UserInvalid", true);
        }

        return userInfo;
    }

    @Transactional(rollbackFor = Throwable.class)
    public void registerUser(String userId, String userName, String password) throws ApplicationException {

        if (this.usersMapper.select(userId) != null) {
            throw new ApplicationException("Error.UserExists", true);
        }

        UsersImpl usersEntity = new UsersImpl();
        Timestamp current = new Timestamp(System.currentTimeMillis());

        usersEntity.setUserId(userId);
        usersEntity.setUsername(userName);
        usersEntity.setPassword(DigestUtils.sha256Hex(password));
        usersEntity.setEnabled(true);
        usersEntity.setProvisionalRegistration(true);
        usersEntity.setLastLogin(null);
        usersEntity.setRegisterDatetime(current);
        usersEntity.setRegisterUserId(userId);
        usersEntity.setUpdatedDatetime(current);
        usersEntity.setUpdatedUserId(userId);
        usersEntity.setVersion(0);

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
