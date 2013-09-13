package jp.myapp.data.entity.management;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import jp.myapp.core.logging.Loggable;
import jp.myapp.core.logging.LoggableUtil;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 権限テーブル主キークラス
 */
public class AuthoritiesPK implements Loggable, Serializable {

    private static final long serialVersionUID = 1L;

    /** ユーザID */
    private String userId;
    /** 権限 */
    private String authority;

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
     * 権限を取得する。
     * 
     * @return 権限
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * 権限を設定する。
     * 
     * @param authority 権限
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public Collection<String> toLogText() {

        ArrayList<String> log = new ArrayList<String>();

        LoggableUtil.addLog(log, userId, "userId");
        LoggableUtil.addLog(log, authority, "authority");

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
