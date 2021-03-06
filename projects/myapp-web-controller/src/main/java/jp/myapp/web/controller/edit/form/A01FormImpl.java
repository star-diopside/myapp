package jp.myapp.web.controller.edit.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import jp.myapp.core.logging.Loggable;
import jp.myapp.core.logging.LoggableUtil;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class A01FormImpl implements A01Form, Loggable, Serializable {

    private static final long serialVersionUID = 1L;

    /** ユーザID */
    private String userId;
    /** パスワード */
    private String password;

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

    @Override
    public Collection<String> toLogText() {

        ArrayList<String> list = new ArrayList<String>();

        LoggableUtil.addLog(list, this.userId, "userId");
        LoggableUtil.addLog(list, this.password, "password");

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
