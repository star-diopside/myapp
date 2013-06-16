package jp.myapp.service.auth;

import java.util.ArrayList;
import java.util.List;

import jp.myapp.bean.userdetails.LoginUser;
import jp.myapp.bean.userdetails.LoginUserImpl;
import jp.myapp.data.entity.management.Users;
import jp.myapp.data.jdbc.mapper.management.UsersRowMapper;

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
            userDetailsList.add(new LoginUserImpl(users));
        }

        return userDetailsList;
    }

    @Override
    protected UserDetails createUserDetails(String username, UserDetails userFromUserQuery,
            List<GrantedAuthority> combinedAuthorities) {

        LoginUser loginUser = (LoginUser) userFromUserQuery;
        UserDetails returnUserDetails = super.createUserDetails(username, userFromUserQuery, combinedAuthorities);

        return new LoginUserImpl(returnUserDetails, loginUser);
    }
}
