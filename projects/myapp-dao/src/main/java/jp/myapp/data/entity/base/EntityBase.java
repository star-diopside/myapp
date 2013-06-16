package jp.myapp.data.entity.base;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import jp.myapp.logging.Loggable;
import jp.myapp.logging.LoggableUtil;

/**
 * エンティティの基底クラス
 * 
 * @param <PK> 主キー情報
 */
public abstract class EntityBase<PK extends Serializable> implements Loggable, Serializable {

    private static final long serialVersionUID = 1L;

    /** 登録日時 */
    private Timestamp registerTimestamp;
    /** 登録ユーザID */
    private String registerUserId;
    /** 更新日時 */
    private Timestamp updatedTimestamp;
    /** 更新ユーザID */
    private String updatedUserId;
    /** バージョン */
    private Integer version;

    /**
     * 主キーを取得する。
     * 
     * @return 主キー
     */
    public abstract PK getPK();

    /**
     * 主キーを設定する。
     * 
     * @param pk 主キー
     */
    public abstract void setPK(PK pk);

    /**
     * 登録日時を取得する。
     * 
     * @return 登録日時
     */
    public Timestamp getRegisterTimestamp() {
        return registerTimestamp;
    }

    /**
     * 登録日時を設定する。
     * 
     * @param registerTimestamp 登録日時
     */
    public void setRegisterTimestamp(Timestamp registerTimestamp) {
        this.registerTimestamp = registerTimestamp;
    }

    /**
     * 登録ユーザIDを取得する。
     * 
     * @return 登録ユーザID
     */
    public String getRegisterUserId() {
        return registerUserId;
    }

    /**
     * 登録ユーザIDを設定する。
     * 
     * @param registerUserId 登録ユーザID
     */
    public void setRegisterUserId(String registerUserId) {
        this.registerUserId = registerUserId;
    }

    /**
     * 更新日時を取得する。
     * 
     * @return 更新日時
     */
    public Timestamp getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    /**
     * 更新日時を設定する。
     * 
     * @param updatedTimestamp 更新日時
     */
    public void setUpdatedTimestamp(Timestamp updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    /**
     * 更新ユーザIDを取得する。
     * 
     * @return 更新ユーザID
     */
    public String getUpdatedUserId() {
        return updatedUserId;
    }

    /**
     * 更新ユーザIDを設定する。
     * 
     * @param updatedUserId 更新ユーザID
     */
    public void setUpdatedUserId(String updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    /**
     * バージョンを取得する。
     * 
     * @return バージョン
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * バージョンを設定する。
     * 
     * @param version バージョン
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public Collection<String> toLogText() {

        ArrayList<String> log = new ArrayList<String>();

        LoggableUtil.addLog(log, registerTimestamp, "registerTimestamp");
        LoggableUtil.addLog(log, registerUserId, "registerUserId");
        LoggableUtil.addLog(log, updatedTimestamp, "updatedTimestamp");
        LoggableUtil.addLog(log, updatedUserId, "updatedUserId");
        LoggableUtil.addLog(log, version, "version");

        return log;
    }
}
