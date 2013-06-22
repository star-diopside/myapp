package jp.myapp.service;

/**
 * 連番生成処理インタフェース
 */
public interface SequentialNumberGenerator {

    /**
     * 連番を生成する。
     * 
     * @param sequentialClassId 連番区分ID
     * @return 生成した連番文字列
     */
    public String generate(String sequentialClassId);

}
