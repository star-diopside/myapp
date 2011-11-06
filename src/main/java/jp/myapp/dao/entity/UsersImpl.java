package jp.myapp.dao.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import jp.myapp.dao.entity.base.EntityBaseImpl;
import jp.myapp.util.Loggable;
import jp.myapp.util.LoggableUtil;

public class UsersImpl extends EntityBaseImpl<String> implements Users, Loggable, Serializable {

    private static final long serialVersionUID = -2678109518889226923L;

    private String userId;
    private String username;
    private String password;
    private Boolean enabled;
    private Boolean provisionalRegistration;
    private Date lastLogin;
    private boolean updatedUsername = false;
    private boolean updatedPassword = false;
    private boolean updatedEnabled = false;
    private boolean updatedProvisionalRegistration = false;
    private boolean updatedLastLogin = false;

    @Override
    public String getPK() {
        return this.getUserId();
    }

    @Override
    public void setPK(String pk) {
        this.setUserId(pk);
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
        this.updatedUsername = true;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
        this.updatedPassword = true;
    }

    @Override
    public Boolean getEnabled() {
        return this.enabled;
    }

    @Override
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
        this.updatedEnabled = true;
    }

    @Override
    public Boolean getProvisionalRegistration() {
        return this.provisionalRegistration;
    }

    @Override
    public void setProvisionalRegistration(Boolean provisionalRegistration) {
        this.provisionalRegistration = provisionalRegistration;
        this.updatedProvisionalRegistration = true;
    }

    @Override
    public Date getLastLogin() {
        return this.lastLogin;
    }

    @Override
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
        this.updatedLastLogin = true;
    }

    @Override
    public boolean isUpdatedUsername() {
        return this.updatedUsername;
    }

    @Override
    public boolean isUpdatedPassword() {
        return this.updatedPassword;
    }

    @Override
    public boolean isUpdatedEnabled() {
        return this.updatedEnabled;
    }

    @Override
    public boolean isUpdatedProvisionalRegistration() {
        return this.updatedProvisionalRegistration;
    }

    @Override
    public boolean isUpdatedLastLogin() {
        return this.updatedLastLogin;
    }

    @Override
    public void resetUsername() {
        this.username = null;
        this.updatedUsername = false;
    }

    @Override
    public void resetPassword() {
        this.password = null;
        this.updatedPassword = false;
    }

    @Override
    public void resetEnabled() {
        this.enabled = null;
        this.updatedEnabled = false;
    }

    @Override
    public void resetProvisionalRegistration() {
        this.provisionalRegistration = null;
        this.updatedProvisionalRegistration = false;
    }

    @Override
    public void resetLastLogin() {
        this.lastLogin = null;
        this.updatedLastLogin = false;
    }

    @Override
    public Collection<String> getLogText() {

        ArrayList<String> log = new ArrayList<String>();

        LoggableUtil.addLog(log, this.userId, "userId");
        LoggableUtil.addLog(log, this.username, "username", this.updatedUsername);
        LoggableUtil.addLog(log, this.password, "password", this.updatedPassword);
        LoggableUtil.addLog(log, this.enabled, "enabled", this.updatedEnabled);
        LoggableUtil.addLog(log, this.provisionalRegistration, "provisionalRegistration",
                this.updatedProvisionalRegistration);
        LoggableUtil.addLog(log, this.lastLogin, "lastLogin", this.updatedLastLogin);
        log.addAll(super.getLogText());

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
