package jp.myapp.batch.logic;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.io.Resource;

public class BA01J030S01 implements Tasklet {

    private Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println(resource.getFile().getPath());
        return RepeatStatus.FINISHED;
    }
}
