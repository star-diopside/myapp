package jp.myapp.batch.logic;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.step.job.DefaultJobParametersExtractor;

/**
 * 次のジョブに引き渡すジョブパラメータ編集を行う。
 */
public class BA01J010S020JobParametersExtractor extends DefaultJobParametersExtractor {

    /** 郵便番号データファイル */
    private String zipFile;

    /**
     * 郵便番号データファイルを設定する。
     * 
     * @param zipFile 郵便番号データファイル
     */
    public void setZipFile(String zipFile) {
        this.zipFile = zipFile;
    }

    @Override
    public JobParameters getJobParameters(Job job, StepExecution stepExecution) {
        JobParametersBuilder builder = new JobParametersBuilder(super.getJobParameters(job, stepExecution));
        builder.addString("zipFile", zipFile);
        return builder.toJobParameters();
    }
}
