package jp.myapp.batch.support;

import java.io.File;
import java.io.IOException;

import jp.myapp.exception.SystemException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * 一時ファイルを生成するJobExecutionListener。<br>
 * 生成した一時ファイルはJobExecutionContextに設定する。
 */
public class TemporaryFileJobExecutionListener implements JobExecutionListener {

    /** 生成した一時ファイル名をJobExecutionContextに格納するキー */
    private String key;

    /** 一時ファイル名の接頭辞文字列 */
    private String prefix;

    /** 一時ファイル名の接尾辞文字列 */
    private String suffix;

    /** 一時ファイルが生成されるディレクトリ */
    private String directory;

    /** ジョブ終了時に一時ファイルを削除するかどうかを示す値 */
    private boolean deleteOnExit = false;

    /**
     * 生成した一時ファイル名をJobExecutionContextに格納するキーを設定する。
     * 
     * @param key 生成した一時ファイル名をJobExecutionContextに格納するキー
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 一時ファイル名の接頭辞文字列を設定する。
     * 
     * @param prefix 一時ファイル名の接頭辞文字列。
     *            {@link File#createTempFile(String, String, File)} のパラメータ
     *            <code>prefix</code> の仕様に従う。
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * 一時ファイル名の接尾辞文字列を設定する。
     * 
     * @param suffix 一時ファイル名の接尾辞文字列
     *            {@link File#createTempFile(String, String, File)} のパラメータ
     *            <code>suffix</code> の仕様に従う。
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * 一時ファイルが生成されるディレクトリを設定する。
     * 
     * @param directory 一時ファイルが生成されるディレクトリ
     *            {@link File#createTempFile(String, String, File)} のパラメータ
     *            <code>directory</code> の仕様に従う。
     */
    public void setDirectory(String directory) {
        this.directory = directory;
    }

    /**
     * ジョブ終了時に一時ファイルを削除するかどうかを示す値を設定する。
     * 
     * @param deleteOnExit <code>true</code>を指定した場合、ジョブ終了時に一時ファイルを削除する。
     */
    public void setDeleteOnExit(boolean deleteOnExit) {
        this.deleteOnExit = deleteOnExit;
    }

    @Override
    public void beforeJob(JobExecution jobExecution) {

        File tempFile;

        try {
            // 一時ファイルを生成する。
            File tempDirectory = StringUtils.isBlank(directory) ? null : new File(directory.trim());

            if (tempDirectory != null) {
                FileUtils.forceMkdir(tempDirectory);
            }

            tempFile = File.createTempFile(prefix, StringUtils.trimToNull(suffix), tempDirectory);

        } catch (IOException e) {
            throw new SystemException(e);
        }

        // 指定されたキー値にパス名を設定する。
        jobExecution.getExecutionContext().putString(key, tempFile.getPath());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {

        if (deleteOnExit) {
            // 一時ファイルを削除する。
            File tempFile = new File(jobExecution.getExecutionContext().getString(key));
            if (!tempFile.delete()) {
                throw new SystemException();
            }

            // 親ディレクトリが空の場合、ディレクトリを削除する。
            File parent = tempFile.getParentFile();
            while (parent != null && parent.list().length == 0) {
                if (!parent.delete()) {
                    throw new SystemException();
                }
                parent = parent.getParentFile();
            }
        }
    }
}
