package jp.myapp.data.entity;

import java.sql.SQLXML;

import jp.myapp.data.entity.base.EntityBase;

public interface UserAttribute extends EntityBase<String> {

    String getUserId();

    void setUserId(String userId);

    SQLXML getAttribute();

    void setAttribute(SQLXML attribute);

}
