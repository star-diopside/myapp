package jp.myapp.test.support;

import org.dbunit.dataset.IDataSet;

/**
 * データベースダンプに関する処理を行うユーティリティインタフェース
 */
public interface DatabaseDumper {

    /**
     * データダンプおよびセットアップを行う。
     * 
     * @param setupDataSet セットアップデータ
     * @return セットアップ前のバックアップデータ
     */
    IDataSet setUp(IDataSet setupDataSet);

}
