package jp.myapp.data.entity.management;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import jp.myapp.data.entity.base.EntityBase;

/**
 * 権限エンティティクラス
 */
public class Authorities extends EntityBase<AuthoritiesPK> {

    private static final long serialVersionUID = 1L;

    /** 主キー */
    private AuthoritiesPK pk;

    /**
     * コンストラクタ
     */
    public Authorities() {
        this.pk = new AuthoritiesPK();
    }

    /**
     * コンストラクタ
     * 
     * @param pk 主キー
     */
    public Authorities(AuthoritiesPK pk) {
        this.pk = pk;
    }

    @Override
    public AuthoritiesPK getPK() {
        return pk;
    }

    @Override
    public void setPK(AuthoritiesPK pk) {
        this.pk = pk;
    }

    /**
     * ユーザIDを取得する。
     * 
     * @return ユーザID
     */
    public String getUserId() {
        return pk.getUserId();
    }

    /**
     * ユーザIDを設定する。
     * 
     * @param userId ユーザID
     */
    public void setUserId(String userId) {
        pk.setUserId(userId);
    }

    /**
     * 権限を取得する。
     * 
     * @return 権限
     */
    public String getAuthority() {
        return pk.getAuthority();
    }

    /**
     * 権限を設定する。
     * 
     * @param authority 権限
     */
    public void setAuthority(String authority) {
        pk.setAuthority(authority);
    }

    @Override
    public Collection<String> toLogText() {

        ArrayList<String> log = new ArrayList<String>();

        log.addAll(pk.toLogText());
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
