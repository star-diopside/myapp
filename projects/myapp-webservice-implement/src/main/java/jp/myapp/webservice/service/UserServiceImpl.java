package jp.myapp.webservice.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.myapp.data.entity.management.Users;
import jp.myapp.data.mapper.management.AuthoritiesMapper;
import jp.myapp.data.mapper.management.UsersMapper;
import jp.myapp.data.support.OptimisticLockControl;
import jp.myapp.webservice.bean.User;

@Service
@WebService(serviceName = "UserService", portName = "UserPort")
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private AuthoritiesMapper authoritiesMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User getUser(String userId) {

        Users entity = this.usersMapper.select(userId);

        User user = new User();
        user.setUserId(entity.getUserId());
        user.setUsername(entity.getUsername());
        user.setVersion(entity.getVersion());

        return user;
    }

    @Override
    @Transactional
    public List<User> getUserList() {

        ArrayList<User> userList = new ArrayList<>();

        for (Users entity : this.usersMapper.selectAll()) {
            User user = new User();
            user.setUserId(entity.getUserId());
            user.setUsername(entity.getUsername());
            user.setVersion(entity.getVersion());
            userList.add(user);
        }

        return userList;
    }

    @Override
    @Transactional
    public User createUser(User user) {

        Users entity = new Users();
        Timestamp current = new Timestamp(System.currentTimeMillis());

        entity.setUserId(user.getUserId());
        entity.setUsername(user.getUsername());
        entity.setPassword(this.passwordEncoder.encode(user.getUserId()));
        entity.setPasswordUpdatedTimestamp(current);
        entity.setEnabled(Boolean.TRUE);
        entity.setInterimRegister(Boolean.TRUE);
        entity.setLoginErrorCount(0);
        entity.setLockoutTimestamp(null);
        entity.setLastLoginTimestamp(null);
        entity.setLogoutTimestamp(null);
        entity.setRegisterTimestamp(current);
        entity.setRegisterUserId(user.getUserId());
        entity.setUpdatedTimestamp(current);
        entity.setUpdatedUserId(user.getUserId());
        entity.setVersion(0);

        this.usersMapper.insert(entity);

        user.setVersion(entity.getVersion());
        return user;
    }

    @Override
    @Transactional
    public User updateUser(User user) {

        Users entity = this.usersMapper.select(user.getUserId());
        Timestamp current = new Timestamp(System.currentTimeMillis());

        entity.setUsername(user.getUsername());
        entity.setUpdatedTimestamp(current);
        entity.setUpdatedUserId(user.getUserId());
        entity.setVersion(user.getVersion());

        (new OptimisticLockControl<>(this.usersMapper)).update(entity);

        user.setVersion(entity.getVersion());
        return user;
    }

    @Override
    @Transactional
    public void deleteUser(String userId, Integer version) {

        (new OptimisticLockControl<>(this.usersMapper)).lock(userId, version);
        this.authoritiesMapper.deleteByUserId(userId);
        this.usersMapper.delete(userId);
    }
}
