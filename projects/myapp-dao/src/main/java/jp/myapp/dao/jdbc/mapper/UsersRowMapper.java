package jp.myapp.dao.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import jp.myapp.dao.entity.Users;
import jp.myapp.dao.entity.UsersImpl;

import org.springframework.jdbc.core.RowMapper;

public class UsersRowMapper implements RowMapper<Users> {

    @Override
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {

        Users users = new UsersImpl();

        users.setUserId(rs.getString("USER_ID"));
        users.setUsername(rs.getString("USERNAME"));
        users.setPassword(rs.getString("PASSWORD"));
        users.setPasswordUpdatedDatetime(rs.getTimestamp("PASSWORD_UPDATED_DATETIME"));
        boolean enabled = rs.getBoolean("ENABLED");
        users.setEnabled(rs.wasNull() ? null : enabled);
        boolean provisionalRegistration = rs.getBoolean("PROVISIONAL_REGISTRATION");
        users.setProvisionalRegistration(rs.wasNull() ? null : provisionalRegistration);
        users.setLastLogin(rs.getTimestamp("LAST_LOGIN"));
        users.setRegisterDatetime(rs.getTimestamp("REGISTER_DATETIME"));
        users.setRegisterUserId(rs.getString("REGISTER_USER_ID"));
        users.setUpdatedDatetime(rs.getTimestamp("UPDATED_DATETIME"));
        users.setUpdatedUserId(rs.getString("UPDATED_USER_ID"));
        int version = rs.getInt("VERSION");
        users.setVersion(rs.wasNull() ? null : version);

        return users;
    }
}
