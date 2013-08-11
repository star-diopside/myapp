package jp.myapp.batch;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class B01Test {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Value("#{@infile}")
    private String infile;

    @Value("#{@outfile}")
    private String outfile;

    @Test
    public void testJob() throws Exception {

        JobParametersBuilder jpb = new JobParametersBuilder(this.jobLauncherTestUtils.getUniqueJobParameters());

        jpb.addString("infile", this.infile);
        jpb.addString("outfile", this.outfile);

        JobExecution jobExecution = this.jobLauncherTestUtils.launchJob(jpb.toJobParameters());

        assertThat(jobExecution.getExitStatus(), is(ExitStatus.COMPLETED));
    }
}
