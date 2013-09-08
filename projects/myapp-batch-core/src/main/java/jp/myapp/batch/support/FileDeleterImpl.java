package jp.myapp.batch.support;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.Resource;

/**
 * ファイル削除処理クラス
 */
public class FileDeleterImpl implements FileDeleter {

    /** 削除対象ファイルリソース */
    private Resource resource;

    /**
     * 削除対象ファイルリソースを設定する。
     * 
     * @param resource 削除対象ファイルリソース
     */
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void delete() throws IOException {

        // 一時ファイルを削除する。
        // ディレクトリが指定された場合、ディレクトリに含まれるファイルを含めて削除する。
        File tempFile = resource.getFile();
        FileUtils.forceDelete(tempFile);

        // 親ディレクトリが空の場合、ディレクトリを削除する。
        File parent = tempFile.getParentFile();
        while (parent != null && parent.list().length == 0) {
            if (!parent.delete()) {
                String message = "Unable to delete directory " + parent + ".";
                throw new IOException(message);
            }
            parent = parent.getParentFile();
        }
    }
}
