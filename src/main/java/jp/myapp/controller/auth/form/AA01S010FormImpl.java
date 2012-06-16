package jp.myapp.controller.auth.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import jp.myapp.logging.Loggable;
import jp.myapp.logging.LoggableUtil;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class AA01S010FormImpl implements AA01S010Form, Loggable, Serializable {

    private static final long serialVersionUID = 1L;

    /** ユーザID */
    private String userId;
    /** パスワード */
    private String password;
    /** ログインエラーかどうかを示す値 */
    private Boolean loginError;

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
     * ログインエラーかどうかを示す値を取得する。
     * 
     * @return ログインエラーの場合にtrue、それ以外の場合はnullまたはfalse。
     */
    @Override
    public Boolean getLoginError() {
        return this.loginError;
    }

    /**
     * ログインエラーかどうかを示す値を設定する。
     * 
     * @param loginError ログインエラーの場合にtrue、それ以外の場合はnullまたはfalse。
     */
    @Override
    public void setLoginError(Boolean loginError) {
        this.loginError = loginError;
    }

    @Override
    public Collection<String> getLogText() {

        ArrayList<String> list = new ArrayList<String>();

        LoggableUtil.addLog(list, this.userId, "userId");
        LoggableUtil.addLog(list, this.password, "password");
        LoggableUtil.addLog(list, this.loginError, "loginError");

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
