package jp.myapp.data.entity.base;

import java.io.Serializable;
import java.sql.Timestamp;

public interface EntityBase<PK extends Serializable> {

    PK getPK();

    void setPK(PK pk);

    Timestamp getRegisterDatetime();

    void setRegisterDatetime(Timestamp registerDatetime);

    String getRegisterUserId();

    void setRegisterUserId(String registerUserId);

    Timestamp getUpdatedDatetime();

    void setUpdatedDatetime(Timestamp updatedDatetime);

    String getUpdatedUserId();

    void setUpdatedUserId(String updatedUserId);

    Integer getVersion();

    void setVersion(Integer version);

}
