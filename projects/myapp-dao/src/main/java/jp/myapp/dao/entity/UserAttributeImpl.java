package jp.myapp.dao.entity;

import java.io.Serializable;
import java.sql.SQLXML;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import jp.myapp.dao.entity.base.EntityBaseImpl;
import jp.myapp.logging.Loggable;
import jp.myapp.logging.LoggableUtil;

public class UserAttributeImpl extends EntityBaseImpl<String> implements UserAttribute, Loggable, Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;
    private SQLXML attribute;

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
    public SQLXML getAttribute() {
        return this.attribute;
    }

    @Override
    public void setAttribute(SQLXML attribute) {
        this.attribute = attribute;
    }

    @Override
    public Collection<String> toLogText() {

        ArrayList<String> log = new ArrayList<String>();

        LoggableUtil.addLog(log, this.userId, "userId");
        LoggableUtil.addLog(log, this.attribute, "attribute");
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
