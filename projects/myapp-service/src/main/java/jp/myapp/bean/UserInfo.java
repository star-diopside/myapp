package jp.myapp.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import jp.myapp.data.entity.Users;
import jp.myapp.data.entity.UsersImpl;
import jp.myapp.logging.Loggable;
import jp.myapp.logging.LoggableUtil;

public class UserInfo implements Users, Loggable, Serializable {

    private static final long serialVersionUID = 1L;

    /** ユーザ情報 */
    private Users users;

    /**
     * コンストラクタ
     */
    public UserInfo() {
        this.users = new UsersImpl();
    }

    /**
     * コンストラクタ
     * 
     * @param source ユーザ情報
     */
    public UserInfo(Users source) {
        this.users = source;
    }

    @Override
    public String getPK() {
        return this.users.getPK();
    }

    @Override
    public void setPK(String pk) {
        this.users.setPK(pk);
    }

    @Override
    public String getUserId() {
        return this.users.getUserId();
    }

    @Override
    public void setUserId(String userId) {
        this.users.setUserId(userId);
    }

    @Override
    public String getUsername() {
        return this.users.getUsername();
    }

    @Override
    public void setUsername(String username) {
        this.users.setUsername(username);
    }

    @Override
    public String getPassword() {
        return this.users.getPassword();
    }

    @Override
    public void setPassword(String password) {
        this.users.setPassword(password);
    }

    @Override
    public Timestamp getPasswordUpdatedDatetime() {
        return this.users.getPasswordUpdatedDatetime();
    }

    @Override
    public void setPasswordUpdatedDatetime(Timestamp passwordUpdatedDatetime) {
        this.users.setPasswordUpdatedDatetime(passwordUpdatedDatetime);
    }

    @Override
    public Boolean getEnabled() {
        return this.users.getEnabled();
    }

    @Override
    public void setEnabled(Boolean enabled) {
        this.users.setEnabled(enabled);
    }

    @Override
    public Boolean getProvisionalRegistration() {
        return this.users.getProvisionalRegistration();
    }

    @Override
    public void setProvisionalRegistration(Boolean provisionalRegistration) {
        this.users.setProvisionalRegistration(provisionalRegistration);
    }

    @Override
    public Integer getLoginErrorCount() {
        return this.users.getLoginErrorCount();
    }

    @Override
    public void setLoginErrorCount(Integer loginErrorCount) {
        this.users.setLoginErrorCount(loginErrorCount);
    }

    @Override
    public Timestamp getLastLoginDatetime() {
        return this.users.getLastLoginDatetime();
    }

    @Override
    public void setLastLoginDatetime(Timestamp lastLoginDatetime) {
        this.users.setLastLoginDatetime(lastLoginDatetime);
    }

    @Override
    public Timestamp getLogoutDatetime() {
        return this.users.getLogoutDatetime();
    }

    @Override
    public void setLogoutDatetime(Timestamp logoutDatetime) {
        this.users.setLogoutDatetime(logoutDatetime);
    }

    @Override
    public Timestamp getRegisterDatetime() {
        return this.users.getRegisterDatetime();
    }

    @Override
    public void setRegisterDatetime(Timestamp registerDatetime) {
        this.users.setRegisterDatetime(registerDatetime);
    }

    @Override
    public String getRegisterUserId() {
        return this.users.getRegisterUserId();
    }

    @Override
    public void setRegisterUserId(String registerUserId) {
        this.users.setRegisterUserId(registerUserId);
    }

    @Override
    public Timestamp getUpdatedDatetime() {
        return this.users.getUpdatedDatetime();
    }

    @Override
    public void setUpdatedDatetime(Timestamp updatedDatetime) {
        this.users.setUpdatedDatetime(updatedDatetime);
    }

    @Override
    public String getUpdatedUserId() {
        return this.users.getUpdatedUserId();
    }

    @Override
    public void setUpdatedUserId(String updatedUserId) {
        this.users.setUpdatedUserId(updatedUserId);
    }

    @Override
    public Integer getVersion() {
        return this.users.getVersion();
    }

    @Override
    public void setVersion(Integer version) {
        this.users.setVersion(version);
    }

    /**
     * 有効なユーザ情報かどうかチェックする。
     * 
     * @return 有効ユーザの場合は true、無効ユーザの場合は false を返す。
     */
    public boolean isValid() {

        if (Boolean.FALSE.equals(this.getProvisionalRegistration())) {
            // 本登録済みの場合、有効ユーザとする。
            return true;

        } else {
            // 仮登録中の場合、登録後１日経過すると無効ユーザとする。
            long duration = System.currentTimeMillis() - this.getRegisterDatetime().getTime();

            if (duration <= TimeUnit.DAYS.toMillis(1)) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public Collection<String> toLogText() {

        ArrayList<String> log = new ArrayList<String>();

        if (this.users instanceof Loggable) {
            LoggableUtil.addLogList(log, ((Loggable) this.users).toLogText(), "users");
        } else {
            LoggableUtil.addLog(log, this.users, "users");
        }

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
