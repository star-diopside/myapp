package jp.myapp.batch.bean;

import java.io.Serializable;

/**
 * 郵便番号住所データ
 */
@SuppressWarnings("serial")
public class PostalCodeAddress implements Serializable {

    /** 全国地方公共団体コード */
    private String localGovernmentCode;

    /** (旧)郵便番号 */
    private String oldPostalCode;

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

    /**
     * フラグ(一町域が二以上の郵便番号で表される場合の表示)
     * <ul>
     * <li>1 : 該当</li>
     * <li>0 : 該当せず</li>
     * </ul>
     */
    private String flag1;

    /**
     * フラグ(小字毎に番地が起番されている町域の表示)
     * <ul>
     * <li>1 : 該当</li>
     * <li>0 : 該当せず</li>
     * </ul>
     */
    private String flag2;

    /**
     * フラグ(丁目を有する町域の場合の表示)
     * <ul>
     * <li>1 : 該当</li>
     * <li>0 : 該当せず</li>
     * </ul>
     */
    private String flag3;

    /**
     * フラグ(一つの郵便番号で二以上の町域を表す場合の表示)
     * <ul>
     * <li>1 : 該当</li>
     * <li>0 : 該当せず</li>
     * </ul>
     */
    private String flag4;

    /**
     * フラグ(更新の表示)
     * <ul>
     * <li>0 : 変更なし</li>
     * <li>1 : 変更あり</li>
     * <li>2 : 廃止(廃止データのみ使用)</li>
     * </ul>
     */
    private String flag5;

    /**
     * フラグ(変更理由)
     * <ul>
     * <li>0 : 変更なし</li>
     * <li>1 : 市政・区政・町政・分区・政令指定都市施行</li>
     * <li>2 : 住居表示の実施</li>
     * <li>3 : 区画整理</li>
     * <li>4 : 郵便区調整等</li>
     * <li>5 : 訂正</li>
     * <li>6 : 廃止(廃止データのみ使用)</li>
     * </ul>
     */
    private String flag6;

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
     * (旧)郵便番号を取得する。
     * 
     * @return (旧)郵便番号
     */
    public String getOldPostalCode() {
        return oldPostalCode;
    }

    /**
     * (旧)郵便番号を設定する。
     * 
     * @param oldPostalCode (旧)郵便番号
     */
    public void setOldPostalCode(String oldPostalCode) {
        this.oldPostalCode = oldPostalCode;
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

    /**
     * フラグ(一町域が二以上の郵便番号で表される場合の表示)を取得する。
     * 
     * @return フラグ(一町域が二以上の郵便番号で表される場合の表示)
     */
    public String getFlag1() {
        return flag1;
    }

    /**
     * フラグ(一町域が二以上の郵便番号で表される場合の表示)を設定する。
     * 
     * @param flag1 フラグ(一町域が二以上の郵便番号で表される場合の表示)
     */
    public void setFlag1(String flag1) {
        this.flag1 = flag1;
    }

    /**
     * フラグ(小字毎に番地が起番されている町域の表示)を取得する。
     * 
     * @return フラグ(小字毎に番地が起番されている町域の表示)
     */
    public String getFlag2() {
        return flag2;
    }

    /**
     * フラグ(小字毎に番地が起番されている町域の表示)を設定する。
     * 
     * @param flag2 フラグ(小字毎に番地が起番されている町域の表示)
     */
    public void setFlag2(String flag2) {
        this.flag2 = flag2;
    }

    /**
     * フラグ(丁目を有する町域の場合の表示)を取得する。
     * 
     * @return フラグ(丁目を有する町域の場合の表示)
     */
    public String getFlag3() {
        return flag3;
    }

    /**
     * フラグ(丁目を有する町域の場合の表示)を設定する。
     * 
     * @param flag3 フラグ(丁目を有する町域の場合の表示)
     */
    public void setFlag3(String flag3) {
        this.flag3 = flag3;
    }

    /**
     * フラグ(一つの郵便番号で二以上の町域を表す場合の表示)を取得する。
     * 
     * @return フラグ(一つの郵便番号で二以上の町域を表す場合の表示)
     */
    public String getFlag4() {
        return flag4;
    }

    /**
     * フラグ(一つの郵便番号で二以上の町域を表す場合の表示)を設定する。
     * 
     * @param flag4 フラグ(一つの郵便番号で二以上の町域を表す場合の表示)
     */
    public void setFlag4(String flag4) {
        this.flag4 = flag4;
    }

    /**
     * フラグ(更新の表示)を取得する。
     * 
     * @return フラグ(更新の表示)
     */
    public String getFlag5() {
        return flag5;
    }

    /**
     * フラグ(更新の表示)を設定する。
     * 
     * @param flag5 フラグ(更新の表示)
     */
    public void setFlag5(String flag5) {
        this.flag5 = flag5;
    }

    /**
     * フラグ(変更理由)を取得する。
     * 
     * @return フラグ(変更理由)
     */
    public String getFlag6() {
        return flag6;
    }

    /**
     * フラグ(変更理由)を設定する。
     * 
     * @param flag6 フラグ(変更理由)
     */
    public void setFlag6(String flag6) {
        this.flag6 = flag6;
    }
}
