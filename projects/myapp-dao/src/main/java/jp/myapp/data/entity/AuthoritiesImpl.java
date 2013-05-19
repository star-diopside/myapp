package jp.myapp.data.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import jp.myapp.data.entity.base.EntityBaseImpl;
import jp.myapp.logging.Loggable;
import jp.myapp.logging.LoggableUtil;

public class AuthoritiesImpl extends EntityBaseImpl<AuthoritiesPK> implements Authorities, Loggable, Serializable {

    private static final long serialVersionUID = 1L;

    private AuthoritiesPK pk;

    public AuthoritiesImpl() {
        this.pk = new AuthoritiesPKImpl();
    }

    public AuthoritiesImpl(AuthoritiesPK pk) {
        this.pk = pk;
    }

    @Override
    public AuthoritiesPK getPK() {
        return this.pk;
    }

    @Override
    public void setPK(AuthoritiesPK pk) {
        this.pk = pk;
    }

    @Override
    public String getUserId() {
        return this.pk.getUserId();
    }

    @Override
    public void setUserId(String userId) {
        this.pk.setUserId(userId);
    }

    @Override
    public String getAuthority() {
        return this.pk.getAuthority();
    }

    @Override
    public void setAuthority(String authority) {
        this.pk.setAuthority(authority);
    }

    @Override
    public Collection<String> toLogText() {

        ArrayList<String> log = new ArrayList<String>();

        LoggableUtil.addLog(log, this.pk.getUserId(), "userId");
        LoggableUtil.addLog(log, this.pk.getAuthority(), "authority");
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