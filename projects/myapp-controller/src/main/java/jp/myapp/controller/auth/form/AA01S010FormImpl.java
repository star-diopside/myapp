package jp.myapp.controller.auth.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import jp.myapp.logging.Loggable;
import jp.myapp.logging.LoggableUtil;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.security.core.AuthenticationException;

public class AA01S010FormImpl implements AA01S010Form, Loggable, Serializable {

    private static final long serialVersionUID = 1L;

    /** ユーザID */
    private String userId;
    /** パスワード */
    private String password;
    /** 認証エラー時の例外情報 */
    private AuthenticationException exception;

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
     * 認証エラー時の例外情報を取得する。
     * 
     * @return 認証成功時はnull、認証失敗時はエラー原因を示す例外情報。
     */
    @Override
    public AuthenticationException getException() {
        return this.exception;
    }

    /**
     * 認証エラー時の例外情報を設定する。
     * 
     * @param exception 認証成功時はnull、認証失敗時はエラー原因を示す例外情報。
     */
    @Override
    public void setException(AuthenticationException exception) {
        this.exception = exception;
    }

    @Override
    public Collection<String> toLogText() {

        ArrayList<String> list = new ArrayList<String>();

        LoggableUtil.addLog(list, this.userId, "userId");
        LoggableUtil.addLog(list, this.password, "password");
        LoggableUtil.addLog(list, this.exception, "exception");

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
