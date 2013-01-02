package jp.myapp.service.auth;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import jp.myapp.bean.userdetails.LoginUserImpl;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

public class LoginUserDetailsManager extends JdbcUserDetailsManager {

    @Override
    protected List<UserDetails> loadUsersByUsername(String username) {
        return this.getJdbcTemplate().query(this.getUsersByUsernameQuery(), new String[] { username },
                new RowMapper<UserDetails>() {
                    @Override
                    public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

                        String username = rs.getString(1);
                        String displayName = rs.getString(2);
                        String password = rs.getString(3);
                        Timestamp passwordUpdatedDatetime = rs.getTimestamp(4);
                        boolean enabled = rs.getBoolean(5);
                        boolean provisionalRegistration = rs.getBoolean(6);
                        Timestamp lastLogin = rs.getTimestamp(7);

                        return new LoginUserImpl(username, displayName, password, passwordUpdatedDatetime, enabled,
                                provisionalRegistration, lastLogin, true, true, true, AuthorityUtils.NO_AUTHORITIES);
                    }
                });
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
