package jp.myapp.batch.mapping;

import java.sql.Timestamp;

import jp.myapp.dao.entity.Users;
import jp.myapp.dao.entity.UsersImpl;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class UsersFieldSetMapper implements FieldSetMapper<Users> {

    @Override
    public Users mapFieldSet(FieldSet fieldSet) throws BindException {

        if (fieldSet == null) {
            return null;
        }

        Users userEntity = new UsersImpl();

        userEntity.setUserId(fieldSet.readString("userId"));
        userEntity.setUsername(fieldSet.readString("username"));
        userEntity.setPassword(fieldSet.readString("password"));
        userEntity.setEnabled(fieldSet.readBoolean("enabled"));
        userEntity.setProvisionalRegistration(fieldSet.readBoolean("provisionalRegistration"));
        userEntity.setLastLogin(new Timestamp(fieldSet.readDate("lastLogin").getTime()));
        userEntity.setRegisterDatetime(new Timestamp(fieldSet.readDate("registerDatetime").getTime()));
        userEntity.setRegisterUserId(fieldSet.readString("registerUserId"));
        userEntity.setUpdatedDatetime(new Timestamp(fieldSet.readDate("updatedDatetime").getTime()));
        userEntity.setUpdatedUserId(fieldSet.readString("updatedUserId"));
        userEntity.setVersion(fieldSet.readInt("version"));

        return userEntity;
    }
}