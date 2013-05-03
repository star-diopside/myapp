package jp.myapp.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import jp.myapp.data.entity.base.EntityBaseImpl;
import jp.myapp.logging.Loggable;
import jp.myapp.logging.LoggableUtil;

public class UsersImpl extends EntityBaseImpl<String> implements Users, Loggable, Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;
    private String username;
    private String password;
    private Timestamp passwordUpdatedDatetime;
    private Boolean enabled;
    private Boolean provisionalRegistration;
    private Integer loginErrorCount;
    private Timestamp lastLoginDatetime;
    private Timestamp logoutDatetime;

    @Override
    public String getPK() {
        return this.userId;
    }

    @Override
    public void setPK(String pk) {
        this.userId = pk;
    }

    @Override
    public String getUserId() {
        return this.userId;
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Timestamp getPasswordUpdatedDatetime() {
        return this.passwordUpdatedDatetime;
    }

    @Override
    public void setPasswordUpdatedDatetime(Timestamp passwordUpdatedDatetime) {
        this.passwordUpdatedDatetime = passwordUpdatedDatetime;
    }

    @Override
    public Boolean getEnabled() {
        return this.enabled;
    }

    @Override
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public Boolean getProvisionalRegistration() {
        return this.provisionalRegistration;
    }

    @Override
    public void setProvisionalRegistration(Boolean provisionalRegistration) {
        this.provisionalRegistration = provisionalRegistration;
    }

    @Override
    public Integer getLoginErrorCount() {
        return this.loginErrorCount;
    }

    @Override
    public void setLoginErrorCount(Integer loginErrorCount) {
        this.loginErrorCount = loginErrorCount;
    }

    @Override
    public Timestamp getLastLoginDatetime() {
        return this.lastLoginDatetime;
    }

    @Override
    public void setLastLoginDatetime(Timestamp lastLoginDatetime) {
        this.lastLoginDatetime = lastLoginDatetime;
    }

    @Override
    public Timestamp getLogoutDatetime() {
        return this.logoutDatetime;
    }

    @Override
    public void setLogoutDatetime(Timestamp logoutDatetime) {
        this.logoutDatetime = logoutDatetime;
    }

    @Override
    public Collection<String> toLogText() {

        ArrayList<String> log = new ArrayList<String>();

        LoggableUtil.addLog(log, this.userId, "userId");
        LoggableUtil.addLog(log, this.username, "username");
        LoggableUtil.addLog(log, this.password, "password");
        LoggableUtil.addLog(log, this.passwordUpdatedDatetime, "passwordUpdatedDatetime");
        LoggableUtil.addLog(log, this.enabled, "enabled");
        LoggableUtil.addLog(log, this.provisionalRegistration, "provisionalRegistration");
        LoggableUtil.addLog(log, this.loginErrorCount, "loginErrorCount");
        LoggableUtil.addLog(log, this.lastLoginDatetime, "lastLoginDatetime");
        LoggableUtil.addLog(log, this.logoutDatetime, "logoutDatetime");
        log.addAll(super.toLogText());

        return log;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, true);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, true);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
