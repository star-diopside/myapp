package jp.myapp.service.auth;

import java.util.ArrayList;
import java.util.List;

import jp.myapp.bean.UserInfo;
import jp.myapp.bean.userdetails.LoginUserImpl;
import jp.myapp.dao.entity.Users;
import jp.myapp.dao.jdbc.mapper.UsersRowMapper;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

public class LoginUserDetailsManager extends JdbcUserDetailsManager {

    @Override
    protected List<UserDetails> loadUsersByUsername(String username) {

        List<Users> usersList = getJdbcTemplate().query(getUsersByUsernameQuery(),
                new String[] { username }, new UsersRowMapper());
        List<UserDetails> userDetailsList = new ArrayList<>(usersList.size());

        for (Users users : usersList) {
            UserInfo info = new UserInfo(users);
            if (info.isValid()) {
                userDetailsList.add(new LoginUserImpl(info));
            }
        }

        return userDetailsList;
    }

    @Override
    protected UserDetails createUserDetails(String username, UserDetails userFromUserQuery,
            List<GrantedAuthority> combinedAuthorities) {

        LoginUserImpl loginUser = (LoginUserImpl) userFromUserQuery;
        UserDetails returnUserDetails = super.createUserDetails(username, userFromUserQuery, combinedAuthorities);

        return new LoginUserImpl(returnUserDetails, loginUser.getDisplayName(), loginUser.getPasswordUpdatedDatetime(),
                loginUser.isProvisionalRegistration(), loginUser.getLastLogin());
    }
}
