package jp.myapp.data.entity.base;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import jp.myapp.logging.Loggable;
import jp.myapp.logging.LoggableUtil;

public abstract class EntityBaseImpl<PK extends Serializable> implements EntityBase<PK>, Loggable {

    private Timestamp registerDatetime;
    private String registerUserId;
    private Timestamp updatedDatetime;
    private String updatedUserId;
    private Integer version;

    @Override
    public Timestamp getRegisterDatetime() {
        return this.registerDatetime;
    }

    @Override
    public void setRegisterDatetime(Timestamp registerDatetime) {
        this.registerDatetime = registerDatetime;
    }

    @Override
    public String getRegisterUserId() {
        return this.registerUserId;
    }

    @Override
    public void setRegisterUserId(String registerUserId) {
        this.registerUserId = registerUserId;
    }

    @Override
    public Timestamp getUpdatedDatetime() {
        return this.updatedDatetime;
    }

    @Override
    public void setUpdatedDatetime(Timestamp updatedDatetime) {
        this.updatedDatetime = updatedDatetime;
    }

    @Override
    public String getUpdatedUserId() {
        return this.updatedUserId;
    }

    @Override
    public void setUpdatedUserId(String updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    @Override
    public Integer getVersion() {
        return this.version;
    }

    @Override
    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public Collection<String> toLogText() {

        ArrayList<String> log = new ArrayList<String>();

        LoggableUtil.addLog(log, this.registerDatetime, "registerDatetime");
        LoggableUtil.addLog(log, this.registerUserId, "registerUserId");
        LoggableUtil.addLog(log, this.updatedDatetime, "updatedDatetime");
        LoggableUtil.addLog(log, this.updatedUserId, "updatedUserId");
        LoggableUtil.addLog(log, this.version, "version");

        return log;
    }
}
