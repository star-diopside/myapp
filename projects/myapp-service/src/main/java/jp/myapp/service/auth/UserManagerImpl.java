package jp.myapp.service.auth;

import java.sql.Timestamp;

import javax.annotation.Resource;

import jp.myapp.bean.UserInfo;
import jp.myapp.bean.userdetails.LoginUser;
import jp.myapp.data.dao.UsersDao;
import jp.myapp.data.entity.Users;
import jp.myapp.data.mapper.AuthoritiesMapper;
import jp.myapp.data.mapper.UsersMapper;
import jp.myapp.data.support.OptimisticLockControl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserManagerImpl implements UserManager {

    @Resource
    private MessageSourceAccessor messages;

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private AuthoritiesMapper authoritiesMapper;

    @Override
    @Transactional(noRollbackFor = AuthenticationException.class)
    public void checkValid(LoginUser user) throws AuthenticationException {

        String userId = user.getUsername();
        UserInfo userInfo = new UserInfo(this.usersMapper.selectForUpdate(userId));

        // ユーザの有効チェックを行う
        if (!userInfo.isValid()) {
            // 無効ユーザの削除を行う
            this.authoritiesMapper.deleteByUserId(userId);
            (new OptimisticLockControl<>(this.usersMapper)).delete(userInfo);
            throw new AccountExpiredException(this.messages.getMessage("Error.UserInvalid"));
        }
    }

    @Override
    @Transactional
    public void loginSuccess(LoginUser user) {

        String userId = user.getUsername();
        Users users = this.usersDao.load(userId);
        Timestamp current = new Timestamp(System.currentTimeMillis());

        users.setLoginErrorCount(0);
        users.setLastLoginDatetime(current);
        users.setLogoutDatetime(null);
        users.setUpdatedDatetime(current);
        users.setUpdatedUserId(userId);

        this.usersDao.update(users);
    }

    @Override
    @Transactional
    public void loginFailure(String userId) {

        Users users = this.usersDao.load(userId);
        Timestamp current = new Timestamp(System.currentTimeMillis());

        users.setLoginErrorCount(users.getLoginErrorCount() + 1);
        users.setUpdatedDatetime(current);
        users.setUpdatedUserId(userId);

        this.usersDao.update(users);
    }

    @Override
    @Transactional
    public void logout(LoginUser user) {

        String userId = user.getUsername();
        Users users = this.usersDao.load(userId);
        Timestamp current = new Timestamp(System.currentTimeMillis());

        users.setLogoutDatetime(current);
        users.setUpdatedDatetime(current);
        users.setUpdatedUserId(userId);

        this.usersDao.update(users);
    }
}
