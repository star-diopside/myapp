package jp.myapp.data.entity.application;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import jp.myapp.core.logging.LoggableUtil;
import jp.myapp.data.entity.base.EntityBase;

/**
 * 郵便番号住所データ
 */
@SuppressWarnings("serial")
public class PostalCode extends EntityBase<Integer> {

    /** ID */
    private Integer id;

    /** 全国地方公共団体コード */
    private String localGovernmentCode;

    /** 郵便番号 */
    private String postalCode;

    /** 都道府県名(カナ) */
    private String kanaPrefectureName;

    /** 市区町村名(カナ) */
    private String kanaMunicipalityName;

    /** 町域名(カナ) */
    private String kanaAreaName;

    /** 都道府県名(漢字) */
    private String kanjiPrefectureName;

    /** 市区町村名(漢字) */
    private String kanjiMunicipalityName;

    /** 町域名(漢字) */
    private String kanjiAreaName;

    @Override
    public Integer getPK() {
        return id;
    }

    @Override
    public void setPK(Integer pk) {
        this.id = pk;
    }

    /**
     * IDを取得する。
     * 
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * IDを設定する。
     * 
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 全国地方公共団体コードを取得する。
     * 
     * @return 全国地方公共団体コード
     */
    public String getLocalGovernmentCode() {
        return localGovernmentCode;
    }

    /**
     * 全国地方公共団体コードを設定する。
     * 
     * @param localGovernmentCode 全国地方公共団体コード
     */
    public void setLocalGovernmentCode(String localGovernmentCode) {
        this.localGovernmentCode = localGovernmentCode;
    }

    /**
     * 郵便番号を取得する。
     * 
     * @return 郵便番号
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * 郵便番号を設定する。
     * 
     * @param postalCode 郵便番号
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * 都道府県名(カナ)を取得する。
     * 
     * @return 都道府県名(カナ)
     */
    public String getKanaPrefectureName() {
        return kanaPrefectureName;
    }

    /**
     * 都道府県名(カナ)を設定する。
     * 
     * @param kanaPrefectureName 都道府県名(カナ)
     */
    public void setKanaPrefectureName(String kanaPrefectureName) {
        this.kanaPrefectureName = kanaPrefectureName;
    }

    /**
     * 市区町村名(カナ)を取得する。
     * 
     * @return 市区町村名(カナ)
     */
    public String getKanaMunicipalityName() {
        return kanaMunicipalityName;
    }

    /**
     * 市区町村名(カナ)を設定する。
     * 
     * @param kanaMunicipalityName 市区町村名(カナ)
     */
    public void setKanaMunicipalityName(String kanaMunicipalityName) {
        this.kanaMunicipalityName = kanaMunicipalityName;
    }

    /**
     * 町域名(カナ)を取得する。
     * 
     * @return 町域名(カナ)
     */
    public String getKanaAreaName() {
        return kanaAreaName;
    }

    /**
     * 町域名(カナ)を設定する。
     * 
     * @param kanaAreaName 町域名(カナ)
     */
    public void setKanaAreaName(String kanaAreaName) {
        this.kanaAreaName = kanaAreaName;
    }

    /**
     * 都道府県名(漢字)を取得する。
     * 
     * @return 都道府県名(漢字)
     */
    public String getKanjiPrefectureName() {
        return kanjiPrefectureName;
    }

    /**
     * 都道府県名(漢字)を設定する。
     * 
     * @param kanjiPrefectureName 都道府県名(漢字)
     */
    public void setKanjiPrefectureName(String kanjiPrefectureName) {
        this.kanjiPrefectureName = kanjiPrefectureName;
    }

    /**
     * 市区町村名(漢字)を取得する。
     * 
     * @return 市区町村名(漢字)
     */
    public String getKanjiMunicipalityName() {
        return kanjiMunicipalityName;
    }

    /**
     * 市区町村名(漢字)を設定する。
     * 
     * @param kanjiMunicipalityName 市区町村名(漢字)
     */
    public void setKanjiMunicipalityName(String kanjiMunicipalityName) {
        this.kanjiMunicipalityName = kanjiMunicipalityName;
    }

    /**
     * 町域名(漢字)を取得する。
     * 
     * @return 町域名(漢字)
     */
    public String getKanjiAreaName() {
        return kanjiAreaName;
    }

    /**
     * 町域名(漢字)を設定する。
     * 
     * @param kanjiAreaName 町域名(漢字)
     */
    public void setKanjiAreaName(String kanjiAreaName) {
        this.kanjiAreaName = kanjiAreaName;
    }

    @Override
    public Collection<String> toLogText() {

        ArrayList<String> log = new ArrayList<String>();

        LoggableUtil.addLog(log, id, "id");
        LoggableUtil.addLog(log, localGovernmentCode, "localGovernmentCode");
        LoggableUtil.addLog(log, postalCode, "postalCode");
        LoggableUtil.addLog(log, kanaPrefectureName, "kanaPrefectureName");
        LoggableUtil.addLog(log, kanaMunicipalityName, "kanaMunicipalityName");
        LoggableUtil.addLog(log, kanaAreaName, "kanaAreaName");
        LoggableUtil.addLog(log, kanjiPrefectureName, "kanjiPrefectureName");
        LoggableUtil.addLog(log, kanjiMunicipalityName, "kanjiMunicipalityName");
        LoggableUtil.addLog(log, kanjiAreaName, "kanjiAreaName");
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
