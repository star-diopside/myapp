package jp.myapp.controller.auth.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import jp.myapp.logging.Loggable;
import jp.myapp.logging.LoggableUtil;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class AA02S010FormImpl implements AA02S010Form, Loggable, Serializable {

    private static final long serialVersionUID = 1L;

    /** ユーザID */
    private String userId;
    /** ユーザ名 */
    private String userName;
    /** パスワード */
    private String password;
    /** Captcha */
    private String captcha;

    /**
     * ユーザIDを取得する。
     * 
     * @return ユーザID
     */
    @Override
    public String getUserId() {
        return this.userId;
    }

    /**
     * ユーザIDを設定する。
     * 
     * @param userId ユーザID
     */
    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * ユーザ名を取得する。
     * 
     * @return ユーザ名
     */
    @Override
    public String getUserName() {
        return this.userName;
    }

    /**
     * ユーザ名を設定する。
     * 
     * @param userName ユーザ名
     */
    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * パスワードを取得する。
     * 
     * @return パスワード
     */
    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * パスワードを設定する。
     * 
     * @param password パスワード
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Captchaを取得する。
     * 
     * @return Captcha
     */
    @Override
    public String getCaptcha() {
        return this.captcha;
    }

    /**
     * Captchaを設定する。
     * 
     * @param captcha Captcha
     */
    @Override
    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    @Override
    public Collection<String> getLogText() {

        ArrayList<String> list = new ArrayList<String>();

        LoggableUtil.addLog(list, this.userId, "userId");
        LoggableUtil.addLog(list, this.userName, "userName");
        LoggableUtil.addLog(list, this.password, "password");
        LoggableUtil.addLog(list, this.captcha, "captcha");

        return list;
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
