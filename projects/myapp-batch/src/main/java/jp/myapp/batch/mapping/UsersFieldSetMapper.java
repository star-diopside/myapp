package jp.myapp.batch.mapping;

import java.sql.Timestamp;

import jp.myapp.data.entity.management.Users;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class UsersFieldSetMapper implements FieldSetMapper<Users> {

    @Override
    public Users mapFieldSet(FieldSet fieldSet) throws BindException {

        if (fieldSet == null) {
            return null;
        }

        Users userEntity = new Users();

        userEntity.setUserId(fieldSet.readString("userId"));
        userEntity.setUsername(fieldSet.readString("username"));
        userEntity.setPassword(fieldSet.readString("password"));
        userEntity.setPasswordUpdatedTimestamp(Timestamp.valueOf(fieldSet.readString("passwordUpdatedTimestamp")));
        userEntity.setEnabled(fieldSet.readBoolean("enabled"));
        userEntity.setInterimRegister(fieldSet.readBoolean("interimRegister"));
        userEntity.setLoginErrorCount(fieldSet.readInt("loginErrorCount"));
        userEntity.setLockoutTimestamp(Timestamp.valueOf(fieldSet.readString("lockoutTimestamp")));
        userEntity.setLastLoginTimestamp(Timestamp.valueOf(fieldSet.readString("lastLoginTimestamp")));
        userEntity.setLogoutTimestamp(Timestamp.valueOf(fieldSet.readString("logoutTimestamp")));
        userEntity.setRegisterTimestamp(Timestamp.valueOf(fieldSet.readString("registerTimestamp")));
        userEntity.setRegisterUserId(fieldSet.readString("registerUserId"));
        userEntity.setUpdatedTimestamp(Timestamp.valueOf(fieldSet.readString("updatedTimestamp")));
        userEntity.setUpdatedUserId(fieldSet.readString("updatedUserId"));
        userEntity.setVersion(fieldSet.readInt("version"));

        return userEntity;
    }
}