package jp.myapp.dao.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import jp.myapp.util.Loggable;
import jp.myapp.util.LoggableUtil;

public class AuthoritiesPKImpl implements AuthoritiesPK, Loggable, Serializable {

    private static final long serialVersionUID = -3293527240831743488L;

    private String userId;
    private String authority;

    @Override
    public String getUserId() {
        return this.userId;
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    @Override
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public Collection<String> getLogText() {

        ArrayList<String> log = new ArrayList<String>();

        LoggableUtil.addLog(log, this.userId, "userId");
        LoggableUtil.addLog(log, this.authority, "authority");

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
