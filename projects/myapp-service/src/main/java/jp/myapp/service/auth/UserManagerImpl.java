package jp.myapp.service.auth;

import java.sql.Timestamp;

import jp.myapp.data.dao.UsersDao;
import jp.myapp.data.entity.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserManagerImpl implements UserManager {

    @Autowired
    private UsersDao usersDao;

    @Override
    @Transactional
    public void loginSuccess(String userId) {

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

        Users users = this.usersDao.get(userId);

        if (users != null) {

            Timestamp current = new Timestamp(System.currentTimeMillis());

            users.setLoginErrorCount(users.getLoginErrorCount() + 1);
            users.setUpdatedDatetime(current);
            users.setUpdatedUserId(userId);

            this.usersDao.update(users);
        }
    }

    @Override
    @Transactional
    public void logout(String userId) {

        Users users = this.usersDao.load(userId);
        Timestamp current = new Timestamp(System.currentTimeMillis());

        users.setLogoutDatetime(current);
        users.setUpdatedDatetime(current);
        users.setUpdatedUserId(userId);

        this.usersDao.update(users);
    }
}
