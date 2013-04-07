package jp.myapp.dao.entity;

import java.sql.Timestamp;

import jp.myapp.dao.entity.base.EntityBase;

public interface Users extends EntityBase<String> {

    String getUserId();

    void setUserId(String userId);

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    Timestamp getPasswordUpdatedDatetime();

    void setPasswordUpdatedDatetime(Timestamp passwordUpdatedDatetime);

    Boolean getEnabled();

    void setEnabled(Boolean enabled);

    Boolean getProvisionalRegistration();

    void setProvisionalRegistration(Boolean provisionalRegistration);

    Timestamp getLastLogin();

    void setLastLogin(Timestamp lastLogin);

    boolean isUpdatedUsername();

    boolean isUpdatedPassword();

    boolean isUpdatedPasswordUpdatedDatetime();

    boolean isUpdatedEnabled();

    boolean isUpdatedProvisionalRegistration();

    boolean isUpdatedLastLogin();

    void resetUsername();

    void resetPassword();

    void resetEnabled();

    void resetProvisionalRegistration();

    void resetLastLogin();

}
