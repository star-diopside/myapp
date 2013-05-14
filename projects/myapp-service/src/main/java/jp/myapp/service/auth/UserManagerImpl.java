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
import jp.myapp.exception.auth.DualLoginException;

import org.apache.commons.lang3.ObjectUtils;
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
    public void checkValid(LoginUser loginUser) throws AuthenticationException {

        Users user = (new OptimisticLockControl<>(this.usersMapper))
                .lock(loginUser.getUserId(), loginUser.getVersion());
        UserInfo userInfo = new UserInfo(user);

        // ユーザの有効チェックを行う
        if (!userInfo.isValid()) {
            // 無効ユーザの削除を行う
            this.authoritiesMapper.deleteByUserId(user.getUserId());
            this.usersMapper.delete(user.getPK());
            throw new AccountExpiredException(this.messages.getMessage("Error.UserInvalid"));
        }
    }

    @Override
    @Transactional
    public void loginSuccess(LoginUser loginUser) {

        Users user = (new OptimisticLockControl<>(this.usersMapper))
                .lock(loginUser.getUserId(), loginUser.getVersion());
        Timestamp current = new Timestamp(System.currentTimeMillis());

        user.setLoginErrorCount(0);
        user.setLastLoginDatetime(current);
        user.setLogoutDatetime(null);
        user.setUpdatedDatetime(current);
        user.setUpdatedUserId(user.getUserId());

        this.usersMapper.update(user);

        // 最終ログイン日時、ログアウト日時を更新する。
        loginUser.setLastLoginDatetime(user.getLastLoginDatetime());
        loginUser.setLogoutDatetime(user.getLogoutDatetime());
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
    public void logout(LoginUser loginUser) {

        String userId = loginUser.getUserId();
        Users user = this.usersDao.load(userId);
        Timestamp current = new Timestamp(System.currentTimeMillis());

        user.setLogoutDatetime(current);
        user.setUpdatedDatetime(current);
        user.setUpdatedUserId(userId);

        this.usersDao.update(user);
    }

    @Override
    @Transactional
    public void checkDualLogin(LoginUser loginUser) throws AuthenticationException {

        Users user = this.usersDao.load(loginUser.getUserId());

        // 最終ログイン日時、ログアウト日時の不変チェックを行う。
        if (ObjectUtils.notEqual(loginUser.getLastLoginDatetime(), user.getLastLoginDatetime())
                || ObjectUtils.notEqual(loginUser.getLogoutDatetime(), user.getLogoutDatetime())) {
            throw new DualLoginException();
        }
    }
}
