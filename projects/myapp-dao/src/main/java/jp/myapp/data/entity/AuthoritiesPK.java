package jp.myapp.data.entity;

import java.io.Serializable;

public interface AuthoritiesPK extends Serializable {

    String getUserId();

    void setUserId(String userId);

    String getAuthority();

    void setAuthority(String authority);

}
