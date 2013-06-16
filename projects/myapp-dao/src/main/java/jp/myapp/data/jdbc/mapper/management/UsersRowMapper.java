package jp.myapp.data.jdbc.mapper.management;

import java.sql.ResultSet;
import java.sql.SQLException;

import jp.myapp.data.entity.management.Users;

import org.springframework.jdbc.core.RowMapper;

public class UsersRowMapper implements RowMapper<Users> {

    @Override
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {

        Users users = new Users();

        users.setUserId(rs.getString("USER_ID"));
        users.setUsername(rs.getString("USERNAME"));
        users.setPassword(rs.getString("PASSWORD"));
        users.setPasswordUpdatedTimestamp(rs.getTimestamp("PASSWORD_UPDATED_TIMESTAMP"));
        boolean enabled = rs.getBoolean("ENABLED");
        users.setEnabled(rs.wasNull() ? null : enabled);
        boolean interimRegister = rs.getBoolean("INTERIM_REGISTER");
        users.setInterimRegister(rs.wasNull() ? null : interimRegister);
        int loginErrorCount = rs.getInt("LOGIN_ERROR_COUNT");
        users.setLoginErrorCount(rs.wasNull() ? null : loginErrorCount);
        users.setLockoutTimestamp(rs.getTimestamp("LOCKOUT_TIMESTAMP"));
        users.setLastLoginTimestamp(rs.getTimestamp("LAST_LOGIN_TIMESTAMP"));
        users.setLogoutTimestamp(rs.getTimestamp("LOGOUT_TIMESTAMP"));
        users.setRegisterTimestamp(rs.getTimestamp("REGISTER_TIMESTAMP"));
        users.setRegisterUserId(rs.getString("REGISTER_USER_ID"));
        users.setUpdatedTimestamp(rs.getTimestamp("UPDATED_TIMESTAMP"));
        users.setUpdatedUserId(rs.getString("UPDATED_USER_ID"));
        int version = rs.getInt("VERSION");
        users.setVersion(rs.wasNull() ? null : version);

        return users;
    }
}
