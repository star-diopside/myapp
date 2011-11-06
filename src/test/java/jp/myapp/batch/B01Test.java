package jp.myapp.batch;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;
import jp.myapp.test.TestTrace;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:job-runner/B01-runner.xml", "classpath:launcher-test.xml" })
public class B01Test {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Rule
    public TestRule testTrace = new TestTrace();

    @Test
    public void testJob() throws Exception {

        JobParametersBuilder jpb = new JobParametersBuilder(this.jobLauncherTestUtils.getUniqueJobParameters());

        jpb.addString("infile", "file:test-data/in/B01-IN.txt");
        jpb.addString("outfile", "file:test-data/out/B01-OUT.txt");

        JobExecution jobExecution = this.jobLauncherTestUtils.launchJob(jpb.toJobParameters());

        assertThat(jobExecution.getExitStatus(), is(ExitStatus.COMPLETED));
    }
}
