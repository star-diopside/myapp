package jp.myapp.batch.logic;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import jp.myapp.batch.support.LoopJobParametersListAccessor;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.core.io.Resource;

/**
 * 郵便番号データZIPファイル解凍処理ステップの実装クラス
 */
public class BA01J020S01Impl implements BA01J020S01, StepExecutionListener {

    /** ジョブ実行オブジェクト */
    private JobExecution jobExecution;

    /** 郵便番号ZIPファイル */
    private Resource resource;

    /** ファイル名のデコードに使用する文字セット */
    private String charset;

    /** ファイル解凍先ディレクトリ */
    private String unarchiveDirectory;

    /** 後続の繰り返しジョブパラメータアクセス処理 */
    private LoopJobParametersListAccessor loopJobParametersListAccessor;

    /**
     * 郵便番号ZIPファイルを設定する。
     * 
     * @param resource 郵便番号ZIPファイル
     */
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    /**
     * ファイル名のデコードに使用する文字セットを設定する。
     * 
     * @param charset ファイル名のデコードに使用する文字セット
     */
    public void setCharset(String charset) {
        this.charset = charset;
    }

    /**
     * ファイル解凍先ディレクトリを設定する。
     * 
     * @param unarchiveDirectory ファイル解凍先ディレクトリ
     */
    public void setUnarchiveDirectory(String unarchiveDirectory) {
        this.unarchiveDirectory = unarchiveDirectory;
    }

    /**
     * 後続の繰り返しジョブパラメータアクセス処理を設定する。
     * 
     * @param loopJobParametersListAccessor 後続の繰り返しジョブパラメータアクセス処理
     */
    public void setLoopJobParametersListAccessor(LoopJobParametersListAccessor loopJobParametersListAccessor) {
        this.loopJobParametersListAccessor = loopJobParametersListAccessor;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        jobExecution = stepExecution.getJobExecution();
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }

    @Override
    public void execute() throws Exception {

        // --------------------------------------------------
        // ZIPファイルを解凍する。
        // --------------------------------------------------
        ArrayList<File> files = new ArrayList<>();

        try (ZipInputStream zis = new ZipInputStream(resource.getInputStream(), Charset.forName(charset))) {

            for (ZipEntry entry; (entry = zis.getNextEntry()) != null; zis.closeEntry()) {

                File file = new File(unarchiveDirectory, entry.getName());
                FileUtils.forceMkdir(file.getParentFile());

                try (FileOutputStream fos = new FileOutputStream(file)) {
                    IOUtils.copyLarge(zis, fos);
                }

                files.add(file);
            }
        }

        // --------------------------------------------------
        // 解凍ファイルを後続ジョブパラメータに設定する。
        // --------------------------------------------------
        List<JobParameters> jobParametersList = loopJobParametersListAccessor.getJobParametersList(jobExecution);

        for (File file : files) {
            JobParametersBuilder jpb = new JobParametersBuilder();
            jpb.addString("infile", "file:" + file.getPath());
            jobParametersList.add(jpb.toJobParameters());
        }
    }
}
