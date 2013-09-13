package jp.myapp.data.entity.application;

import java.sql.SQLXML;
import java.util.ArrayList;
import java.util.Collection;

import jp.myapp.core.logging.LoggableUtil;
import jp.myapp.data.entity.base.EntityBase;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * ユーザ属性エンティティクラス
 */
public class UserAttribute extends EntityBase<String> {

    private static final long serialVersionUID = 1L;

    /** ユーザID */
    private String userId;
    /** 属性 */
    private SQLXML attribute;

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
     * 属性を取得する。
     * 
     * @return 属性
     */
    public SQLXML getAttribute() {
        return attribute;
    }

    /**
     * 属性を設定する。
     * 
     * @param attribute 属性
     */
    public void setAttribute(SQLXML attribute) {
        this.attribute = attribute;
    }

    @Override
    public Collection<String> toLogText() {

        ArrayList<String> log = new ArrayList<String>();

        LoggableUtil.addLog(log, userId, "userId");
        LoggableUtil.addLog(log, attribute, "attribute");
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
