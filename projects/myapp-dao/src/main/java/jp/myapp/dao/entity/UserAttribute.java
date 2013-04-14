package jp.myapp.dao.entity;

import java.sql.SQLXML;

import jp.myapp.dao.entity.base.EntityBase;

public interface UserAttribute extends EntityBase<String> {

    String getUserId();

    void setUserId(String userId);

    SQLXML getAttribute();

    void setAttribute(SQLXML attribute);

}
