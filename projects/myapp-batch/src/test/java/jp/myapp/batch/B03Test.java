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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@ActiveProfiles({ "test" })
public class B03Test {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void testJob() throws Exception {

        JobParametersBuilder jpb = new JobParametersBuilder(this.jobLauncherTestUtils.getUniqueJobParameters());

        JobExecution jobExecution = this.jobLauncherTestUtils.launchJob(jpb.toJobParameters());

        assertThat(jobExecution.getExitStatus(), is(ExitStatus.COMPLETED));
    }
}