package jp.myapp.data.entity.management;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import jp.myapp.core.logging.LoggableUtil;
import jp.myapp.data.entity.base.EntityBase;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * ユーザエンティティクラス
 */
public class Users extends EntityBase<String> {

    private static final long serialVersionUID = 1L;

    /** ユーザID */
    private String userId;
    /** ユーザ名 */
    private String username;
    /** パスワード */
    private String password;
    /** パスワード更新日時 */
    private Timestamp passwordUpdatedTimestamp;
    /** 有効フラグ */
    private Boolean enabled;
    /** 仮登録フラグ */
    private Boolean interimRegister;
    /** ログインエラー回数 */
    private Integer loginErrorCount;
    /** ロックアウト日時 */
    private Timestamp lockoutTimestamp;
    /** 最終ログイン日時 */
    private Timestamp lastLoginTimestamp;
    /** ログアウト日時 */
    private Timestamp logoutTimestamp;

    @Override
    public String getPK() {
        return userId;
    }

    @Override
    public void setPK(String pk) {
        userId = pk;
    }

    /**
     * ユーザIDを取得する。
     * 
     * @return ユーザID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ユーザIDを設定する。
     * 
     * @param userId ユーザID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * ユーザ名を取得する。
     * 
     * @return ユーザ名
     */
    public String getUsername() {
        return username;
    }

    /**
     * ユーザ名を設定する。
     * 
     * @param username ユーザ名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * パスワードを取得する。
     * 
     * @return パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * パスワードを設定する。
     * 
     * @param password パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * パスワード更新日時を取得する。
     * 
     * @return パスワード更新日時
     */
    public Timestamp getPasswordUpdatedTimestamp() {
        return passwordUpdatedTimestamp;
    }

    /**
     * パスワード更新日時を設定する。
     * 
     * @param passwordUpdatedTimestamp パスワード更新日時
     */
    public void setPasswordUpdatedTimestamp(Timestamp passwordUpdatedTimestamp) {
        this.passwordUpdatedTimestamp = passwordUpdatedTimestamp;
    }

    /**
     * 有効フラグを取得する。
     * 
     * @return 有効フラグ
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * 有効フラグを設定する。
     * 
     * @param enabled 有効フラグ
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 仮登録フラグを取得する。
     * 
     * @return 仮登録フラグ
     */
    public Boolean getInterimRegister() {
        return interimRegister;
    }

    /**
     * 仮登録フラグを設定する。
     * 
     * @param interimRegister 仮登録フラグ
     */
    public void setInterimRegister(Boolean interimRegister) {
        this.interimRegister = interimRegister;
    }

    /**
     * ログインエラー回数を取得する。
     * 
     * @return ログインエラー回数
     */
    public Integer getLoginErrorCount() {
        return loginErrorCount;
    }

    /**
     * ログインエラー回数を設定する。
     * 
     * @param loginErrorCount ログインエラー回数
     */
    public void setLoginErrorCount(Integer loginErrorCount) {
        this.loginErrorCount = loginErrorCount;
    }

    /**
     * ロックアウト日時を取得する。
     * 
     * @return ロックアウト日時
     */
    public Timestamp getLockoutTimestamp() {
        return lockoutTimestamp;
    }

    /**
     * ロックアウト日時を設定する。
     * 
     * @param lockoutTimestamp ロックアウト日時
     */
    public void setLockoutTimestamp(Timestamp lockoutTimestamp) {
        this.lockoutTimestamp = lockoutTimestamp;
    }

    /**
     * 最終ログイン日時を取得する。
     * 
     * @return 最終ログイン日時
     */
    public Timestamp getLastLoginTimestamp() {
        return lastLoginTimestamp;
    }

    /**
     * 最終ログイン日時を設定する。
     * 
     * @param lastLoginTimestamp 最終ログイン日時
     */
    public void setLastLoginTimestamp(Timestamp lastLoginTimestamp) {
        this.lastLoginTimestamp = lastLoginTimestamp;
    }

    /**
     * ログアウト日時を取得する。
     * 
     * @return ログアウト日時
     */
    public Timestamp getLogoutTimestamp() {
        return logoutTimestamp;
    }

    /**
     * ログアウト日時を設定する。
     * 
     * @param logoutTimestamp ログアウト日時
     */
    public void setLogoutTimestamp(Timestamp logoutTimestamp) {
        this.logoutTimestamp = logoutTimestamp;
    }

    @Override
    public Collection<String> toLogText() {

        ArrayList<String> log = new ArrayList<String>();

        LoggableUtil.addLog(log, userId, "userId");
        LoggableUtil.addLog(log, username, "username");
        LoggableUtil.addLog(log, password, "password");
        LoggableUtil.addLog(log, passwordUpdatedTimestamp, "passwordUpdatedTimestamp");
        LoggableUtil.addLog(log, enabled, "enabled");
        LoggableUtil.addLog(log, interimRegister, "interimRegister");
        LoggableUtil.addLog(log, loginErrorCount, "loginErrorCount");
        LoggableUtil.addLog(log, lockoutTimestamp, "lockoutTimestamp");
        LoggableUtil.addLog(log, lastLoginTimestamp, "lastLoginTimestamp");
        LoggableUtil.addLog(log, logoutTimestamp, "logoutTimestamp");
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
