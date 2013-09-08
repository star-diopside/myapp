package jp.myapp.batch.support;

import java.io.IOException;

/**
 * ファイル削除処理インタフェース
 */
public interface FileDeleter {

    /**
     * ファイルを削除する。
     * 
     * @throws IOException ファイル入出力エラーが発生した場合
     */
    void delete() throws IOException;

}
