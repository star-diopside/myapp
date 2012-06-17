package jp.myapp.dao.entity.base;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import jp.myapp.logging.Loggable;
import jp.myapp.logging.LoggableUtil;

public abstract class EntityBaseImpl<PK> implements EntityBase<PK>, Loggable {

    private Timestamp registerDatetime;
    private String registerUserId;
    private Timestamp updatedDatetime;
    private String updatedUserId;
    private Integer version;
    private boolean updatedRegisterDatetime = false;
    private boolean updatedRegisterUserId = false;
    private boolean updatedUpdatedDatetime = false;
    private boolean updatedUpdatedUserId = false;
    private boolean updatedVersion = false;

    @Override
    public Timestamp getRegisterDatetime() {
        return this.registerDatetime;
    }

    @Override
    public void setRegisterDatetime(Timestamp registerDatetime) {
        this.registerDatetime = registerDatetime;
        this.updatedRegisterDatetime = true;
    }

    @Override
    public String getRegisterUserId() {
        return this.registerUserId;
    }

    @Override
    public void setRegisterUserId(String registerUserId) {
        this.registerUserId = registerUserId;
        this.updatedRegisterUserId = true;
    }

    @Override
    public Timestamp getUpdatedDatetime() {
        return this.updatedDatetime;
    }

    @Override
    public void setUpdatedDatetime(Timestamp updatedDatetime) {
        this.updatedDatetime = updatedDatetime;
        this.updatedUpdatedDatetime = true;
    }

    @Override
    public String getUpdatedUserId() {
        return this.updatedUserId;
    }

    @Override
    public void setUpdatedUserId(String updatedUserId) {
        this.updatedUserId = updatedUserId;
        this.updatedUpdatedUserId = true;
    }

    @Override
    public Integer getVersion() {
        return this.version;
    }

    @Override
    public void setVersion(Integer version) {
        this.version = version;
        this.updatedVersion = true;
    }

    @Override
    public boolean isUpdatedRegisterDatetime() {
        return this.updatedRegisterDatetime;
    }

    @Override
    public boolean isUpdatedRegisterUserId() {
        return this.updatedRegisterUserId;
    }

    @Override
    public boolean isUpdatedUpdatedDatetime() {
        return this.updatedUpdatedDatetime;
    }

    @Override
    public boolean isUpdatedUpdatedUserId() {
        return this.updatedUpdatedUserId;
    }

    @Override
    public boolean isUpdatedVersion() {
        return this.updatedVersion;
    }

    @Override
    public void resetRegisterDatetime() {
        this.registerDatetime = null;
        this.updatedRegisterDatetime = false;
    }

    @Override
    public void resetRegisterUserId() {
        this.registerUserId = null;
        this.updatedRegisterUserId = false;
    }

    @Override
    public void resetUpdatedDatetime() {
        this.updatedDatetime = null;
        this.updatedUpdatedDatetime = false;
    }

    @Override
    public void resetUpdatedUserId() {
        this.updatedUserId = null;
        this.updatedUpdatedUserId = false;
    }

    @Override
    public void resetVersion() {
        this.version = null;
        this.updatedVersion = false;
    }

    @Override
    public Collection<String> toLogText() {

        ArrayList<String> log = new ArrayList<String>();

        LoggableUtil.addLog(log, this.registerDatetime, "registerDatetime", this.updatedRegisterDatetime);
        LoggableUtil.addLog(log, this.registerUserId, "registerUserId", this.updatedRegisterUserId);
        LoggableUtil.addLog(log, this.updatedDatetime, "updatedDatetime", this.updatedUpdatedDatetime);
        LoggableUtil.addLog(log, this.updatedUserId, "updatedUserId", this.updatedUpdatedUserId);
        LoggableUtil.addLog(log, this.version, "version", this.updatedVersion);

        return log;
    }
}
