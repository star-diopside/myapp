package jp.myapp.data.entity;

import java.sql.Timestamp;

import jp.myapp.data.entity.base.EntityBase;

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

    Integer getLoginErrorCount();

    void setLoginErrorCount(Integer loginErrorCount);

    Timestamp getLastLoginDatetime();

    void setLastLoginDatetime(Timestamp lastLoginDatetime);

    Timestamp getLogoutDatetime();

    void setLogoutDatetime(Timestamp logoutDatetime);

}
