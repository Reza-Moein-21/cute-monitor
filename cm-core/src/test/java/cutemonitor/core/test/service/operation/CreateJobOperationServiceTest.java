package cutemonitor.core.test.service.operation;

import gmail.rezamoeinpe.cutemonitor.core.exception.JobOperationException;
import gmail.rezamoeinpe.cutemonitor.core.model.CronModel;
import gmail.rezamoeinpe.cutemonitor.core.model.JobModel;
import gmail.rezamoeinpe.cutemonitor.core.service.JobOperationService;
import gmail.rezamoeinpe.cutemonitor.core.service.provider.JobOperationServiceImpl;
import gmail.rezamoeinpe.cutemonitor.core.service.provider.JobValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@ContextConfiguration(classes = {
        JobOperationServiceImpl.class,
        JobValidator.class
})
class CreateJobOperationServiceTest {

    @Autowired
    JobOperationService service;

    @Test
    void jobModelIsNull_create_shouldThrowException() {
        assertThatThrownBy(() -> this.service.create(null))
                .isInstanceOf(JobOperationException.class)
                .hasCauseInstanceOf(NullPointerException.class)
                .hasMessageContaining("job model is null");
    }

    @Test
    void jobModelRequiredFieldIsNull_create_shouldThrowException() {
        assertThatThrownBy(() -> {
            var job = new JobModel();
            this.service.create(job);
        }).isInstanceOf(JobOperationException.class)
                .hasCauseInstanceOf(NullPointerException.class)
                .hasMessageContaining("job name is null");

        assertThatThrownBy(() -> {
            var job = new JobModel();
            job.setName("job name");
            this.service.create(job);
        }).isInstanceOf(JobOperationException.class)
                .hasCauseInstanceOf(NullPointerException.class)
                .hasMessageContaining("job cron is null");
    }


    @Test
    void afterCreateOneJob_create_shouldLoadOneSameCreatedJob() {
        var validJob = new JobModel();
        validJob.setName("Valid Job");
        validJob.setCron(new CronModel());
        service.create(validJob);


        List<JobModel> jobs = service.search(validJob);
        assertThat(jobs)
                .filteredOn(jobModel -> jobModel.getName().equals(validJob.getName()))
                .filteredOn(jobModel -> Objects.nonNull(jobModel.getId()))
                .hasSize(1);
    }
}
