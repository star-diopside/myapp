package jp.myapp.webservice.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.myapp.data.entity.Users;
import jp.myapp.data.entity.UsersImpl;
import jp.myapp.data.mapper.AuthoritiesMapper;
import jp.myapp.data.mapper.UserAttributeMapper;
import jp.myapp.data.mapper.UsersMapper;
import jp.myapp.data.support.OptimisticLockControl;
import jp.myapp.function.UserManager;
import jp.myapp.webservice.bean.User;

@Service
@WebService(serviceName = "UserService", portName = "UserPort")
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private AuthoritiesMapper authoritiesMapper;

    @Autowired
    private UserAttributeMapper userAttributeMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserManager userManager;

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

        UsersImpl entity = new UsersImpl();
        Timestamp current = new Timestamp(System.currentTimeMillis());

        entity.setUserId(user.getUserId());
        entity.setUsername(user.getUsername());
        entity.setPassword(this.passwordEncoder.encodePassword(user.getUserId(), current));
        entity.setPasswordUpdatedDatetime(current);
        entity.setEnabled(Boolean.TRUE);
        entity.setProvisionalRegistration(Boolean.TRUE);
        entity.setLastLogin(null);
        entity.setRegisterDatetime(current);
        entity.setRegisterUserId(user.getUserId());
        entity.setUpdatedDatetime(current);
        entity.setUpdatedUserId(user.getUserId());
        entity.setVersion(0);

        this.usersMapper.insert(entity);

        this.userManager.process(user.getUserId());

        user.setVersion(entity.getVersion());
        return user;
    }

    @Override
    @Transactional
    public User updateUser(User user) {

        Users entity = this.usersMapper.select(user.getUserId());
        Timestamp current = new Timestamp(System.currentTimeMillis());

        entity.setUsername(user.getUsername());
        entity.setUpdatedDatetime(current);
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
        this.userAttributeMapper.delete(userId);
        this.usersMapper.delete(userId);
    }
}
