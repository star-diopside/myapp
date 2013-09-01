package jp.myapp.batch.logic;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class BA01J010Test {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void testJob() throws Exception {

        JobParametersBuilder jpb = new JobParametersBuilder(this.jobLauncherTestUtils.getUniqueJobParameters());

        JobExecution jobExecution = this.jobLauncherTestUtils.launchJob(jpb.toJobParameters());

        assertThat(jobExecution.getExitStatus(), is(ExitStatus.COMPLETED));
    }
}
