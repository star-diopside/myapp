package jp.myapp.service.logic.auth;

import java.sql.Timestamp;

import javax.annotation.Resource;

import jp.myapp.data.dao.management.UsersDao;
import jp.myapp.data.entity.management.Users;
import jp.myapp.data.mapper.management.AuthoritiesMapper;
import jp.myapp.data.mapper.management.UsersMapper;
import jp.myapp.data.support.OptimisticLockControl;
import jp.myapp.service.bean.UserInfoUtil;
import jp.myapp.service.bean.userdetails.LoginUser;
import jp.myapp.service.exception.auth.DualLoginException;

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

        // ユーザの有効チェックを行う
        if (!UserInfoUtil.isValid(user)) {
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
        user.setLastLoginTimestamp(current);
        user.setLogoutTimestamp(null);
        user.setUpdatedTimestamp(current);
        user.setUpdatedUserId(user.getUserId());

        this.usersMapper.update(user);

        // 最終ログイン日時、ログアウト日時を更新する。
        loginUser.setLastLoginTimestamp(user.getLastLoginTimestamp());
        loginUser.setLogoutTimestamp(user.getLogoutTimestamp());
    }

    @Override
    @Transactional
    public void loginFailure(String userId) {

        Users users = this.usersDao.load(userId);
        Timestamp current = new Timestamp(System.currentTimeMillis());

        users.setLoginErrorCount(users.getLoginErrorCount() + 1);
        users.setUpdatedTimestamp(current);
        users.setUpdatedUserId(userId);

        this.usersDao.update(users);
    }

    @Override
    @Transactional
    public void logout(LoginUser loginUser) {

        String userId = loginUser.getUserId();
        Users user = this.usersDao.loadForUpdate(userId);

        // ログイン情報が更新されていない場合、ログアウト処理を行う。
        if (!checkLoginInfo(loginUser, user)) {
            Timestamp current = new Timestamp(System.currentTimeMillis());
            user.setLogoutTimestamp(current);
            user.setUpdatedTimestamp(current);
            user.setUpdatedUserId(userId);
            this.usersDao.update(user);
        }
    }

    @Override
    @Transactional
    public void checkDualLogin(LoginUser loginUser) throws AuthenticationException {

        Users user = this.usersDao.load(loginUser.getUserId());

        // ログイン情報が更新されている場合、二重ログイン例外をスローする。
        if (checkLoginInfo(loginUser, user)) {
            throw new DualLoginException();
        }
    }

    /**
     * ログイン情報の不変チェックを行う。
     * 
     * @param loginUser ログインユーザ情報
     * @param user ユーザテーブルから取得したユーザ情報
     * @return ログイン後にログイン情報が更新されている場合はtrue、それ以外の場合はfalse。
     */
    private boolean checkLoginInfo(LoginUser loginUser, Users user) {

        // 最終ログイン日時、ログアウト日時の判定を行う。
        return ObjectUtils.notEqual(loginUser.getLastLoginTimestamp(), user.getLastLoginTimestamp())
                || ObjectUtils.notEqual(loginUser.getLogoutTimestamp(), user.getLogoutTimestamp());
    }
}
