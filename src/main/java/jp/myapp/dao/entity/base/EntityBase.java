package jp.myapp.dao.entity.base;

import java.util.Date;

public interface EntityBase<PK> {

    PK getPK();

    void setPK(PK pk);

    Date getRegisterDatetime();

    void setRegisterDatetime(Date registerDatetime);

    String getRegisterUserId();

    void setRegisterUserId(String registerUserId);

    Date getUpdatedDatetime();

    void setUpdatedDatetime(Date updatedDatetime);

    String getUpdatedUserId();

    void setUpdatedUserId(String updatedUserId);

    Integer getVersion();

    void setVersion(Integer version);

    boolean isUpdatedRegisterDatetime();

    boolean isUpdatedRegisterUserId();

    boolean isUpdatedUpdatedDatetime();

    boolean isUpdatedUpdatedUserId();

    boolean isUpdatedVersion();

    void resetRegisterDatetime();

    void resetRegisterUserId();

    void resetUpdatedDatetime();

    void resetUpdatedUserId();

    void resetVersion();

}
