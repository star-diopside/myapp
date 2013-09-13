package jp.myapp.batch.support;

import java.io.File;
import java.io.IOException;

import jp.myapp.core.exception.SystemException;
import jp.myapp.support.util.SimpleDateFormatUtils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;

/**
 * 一時ディレクトリを生成する{@link StepExecutionListener}。<br>
 * 生成した一時ディレクトリ名はStepExecutionContextに設定する。
 */
public class CreateTemporaryDirectoryListener extends StepExecutionListenerSupport {

    /** 生成した一時ディレクトリ名をStepExecutionContextに格納するキー */
    private String key;

    /** 一時ディレクトリ名の接頭辞文字列 */
    private String prefix;

    /** 一時ディレクトリ名の接尾辞文字列 */
    private String suffix;

    /** 一時ディレクトリを生成する親ディレクトリ */
    private String directory;

    /**
     * 生成した一時ディレクトリ名をStepExecutionContextに格納するキーを設定する。
     * 
     * @param key 生成した一時ディレクトリ名をStepExecutionContextに格納するキー
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 一時ディレクトリ名の接頭辞文字列を設定する。
     * 
     * @param prefix 一時ディレクトリ名の接頭辞文字列
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * 一時ディレクトリ名の接尾辞文字列を設定する。
     * 
     * @param suffix 一時ディレクトリ名の接尾辞文字列
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * 一時ディレクトリを生成する親ディレクトリを設定する。
     * 
     * @param directory 一時ディレクトリを生成する親ディレクトリ
     */
    public void setDirectory(String directory) {
        this.directory = directory;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {

        File tempFile;

        try {
            File tempDirectory = StringUtils.isBlank(directory) ? FileUtils.getTempDirectory() : new File(directory.trim());
            tempFile = new File(tempDirectory, StringUtils.defaultString(prefix)
                    + SimpleDateFormatUtils.FORMATTER_YYYYMMDDHHMMSSSSS.get().format(stepExecution.getStartTime())
                    + StringUtils.defaultString(suffix));

            if (tempDirectory != null) {
                FileUtils.forceMkdir(tempDirectory);
            }

        } catch (IOException e) {
            throw new SystemException(e);
        }

        // 指定されたキー値にパス名を設定する。
        stepExecution.getExecutionContext().putString(key, tempFile.getPath());
    }
}
