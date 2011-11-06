package jp.myapp.dao.entity;

import java.util.Date;

import jp.myapp.dao.entity.base.EntityBase;

public interface Users extends EntityBase<String> {

    String getUserId();

    void setUserId(String userId);

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    Boolean getEnabled();

    void setEnabled(Boolean enabled);

    Boolean getProvisionalRegistration();

    void setProvisionalRegistration(Boolean provisionalRegistration);

    Date getLastLogin();

    void setLastLogin(Date lastLogin);

    boolean isUpdatedUsername();

    boolean isUpdatedPassword();

    boolean isUpdatedEnabled();

    boolean isUpdatedProvisionalRegistration();

    boolean isUpdatedLastLogin();

    void resetUsername();

    void resetPassword();

    void resetEnabled();

    void resetProvisionalRegistration();

    void resetLastLogin();

}
