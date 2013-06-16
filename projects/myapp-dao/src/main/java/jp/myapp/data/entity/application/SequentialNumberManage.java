package jp.myapp.data.entity.application;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import jp.myapp.data.entity.base.EntityBase;
import jp.myapp.logging.LoggableUtil;

/**
 * 連番管理エンティティクラス
 */
public class SequentialNumberManage extends EntityBase<String> {

    private static final long serialVersionUID = 1L;

    /** 連番区分ID */
    private String sequentialClassId;
    /** 連番値 */
    private Integer sequentialValue;
    /** 桁数 */
    private Integer digits;
    /** プレフィックス */
    private String prefix;
    /** サフィックス */
    private String suffix;
    /** 生成パターン */
    private String generatePattern;

    @Override
    public String getPK() {
        return sequentialClassId;
    }

    @Override
    public void setPK(String pk) {
        sequentialClassId = pk;
    }

    /**
     * 連番区分IDを取得する。
     * 
     * @return 連番区分ID
     */
    public String getSequentialClassId() {
        return sequentialClassId;
    }

    /**
     * 連番区分IDを設定する。
     * 
     * @param sequentialClassId 連番区分ID
     */
    public void setSequentialClassId(String sequentialClassId) {
        this.sequentialClassId = sequentialClassId;
    }

    /**
     * 連番値を取得する。
     * 
     * @return 連番値
     */
    public Integer getSequentialValue() {
        return sequentialValue;
    }

    /**
     * 連番値を設定する。
     * 
     * @param sequentialValue 連番値
     */
    public void setSequentialValue(Integer sequentialValue) {
        this.sequentialValue = sequentialValue;
    }

    /**
     * 桁数を取得する。
     * 
     * @return 桁数
     */
    public Integer getDigits() {
        return digits;
    }

    /**
     * 桁数を設定する。
     * 
     * @param digits 桁数
     */
    public void setDigits(Integer digits) {
        this.digits = digits;
    }

    /**
     * プレフィックスを取得する。
     * 
     * @return プレフィックス
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * プレフィックスを設定する。
     * 
     * @param prefix プレフィックス
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * サフィックスを取得する。
     * 
     * @return サフィックス
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * サフィックスを設定する。
     * 
     * @param suffix サフィックス
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * 生成パターンを取得する。
     * 
     * @return 生成パターン
     */
    public String getGeneratePattern() {
        return generatePattern;
    }

    /**
     * 生成パターンを設定する。
     * 
     * @param generatePattern 生成パターン
     */
    public void setGeneratePattern(String generatePattern) {
        this.generatePattern = generatePattern;
    }

    @Override
    public Collection<String> toLogText() {

        ArrayList<String> log = new ArrayList<String>();

        LoggableUtil.addLog(log, sequentialClassId, "sequentialClassId");
        LoggableUtil.addLog(log, sequentialValue, "sequentialValue");
        LoggableUtil.addLog(log, digits, "digits");
        LoggableUtil.addLog(log, prefix, "prefix");
        LoggableUtil.addLog(log, suffix, "suffix");
        LoggableUtil.addLog(log, generatePattern, "generatePattern");
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
