package cutemonitor.db.test.service;

import gmail.rezamoeinpe.cutemonitor.db._public.exception.JobOperationException;
import gmail.rezamoeinpe.cutemonitor.db._public.service.JobOperationService;
import gmail.rezamoeinpe.cutemonitor.db.service.JobOperationServiceImpl;
import gmail.rezamoeinpe.cutemonitor.db.service.JobValidator;
import gmail.rezamoeinpe.cutemonitor.domain._publics.CronModel;
import gmail.rezamoeinpe.cutemonitor.domain._publics.JobModel;
import gmail.rezamoeinpe.cutemonitor.domain._publics.RestJobTemplateModel;
import gmail.rezamoeinpe.cutemonitor.domain._publics.enums.JobStatusEnum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

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
    void givingNullJobModel_create_shouldThrowOperationException() {
        assertThatThrownBy(() -> this.service.create(null))
                .isInstanceOf(JobOperationException.class)
                .hasCauseInstanceOf(NullPointerException.class)
                .hasMessageContaining("job model is null");
    }

    @Test
    void givingNullJobName_callCreate_shouldThrowOperationException() {
        assertThatThrownBy(() -> {
            var job = new JobModel();
            this.service.create(job);
        }).isInstanceOf(JobOperationException.class)
                .hasCauseInstanceOf(NullPointerException.class)
                .hasMessageContaining("job name is null");
    }

    @Test
    void givingNullJobStatus_callCreate_shouldThrowOperationException() {
        assertThatThrownBy(() -> {
            var job = getSimpleValidJob();
            job.setStatus(null);
            this.service.create(job);
        }).isInstanceOf(JobOperationException.class)
                .hasCauseInstanceOf(NullPointerException.class)
                .hasMessageContaining("job status is null");
    }

    @Test
    void givingNullJobCron_callCreate_shouldThrowOperationException() {
        assertThatThrownBy(() -> {
            var job = getSimpleValidJob();
            job.setCron(null);
            this.service.create(job);
        }).isInstanceOf(JobOperationException.class)
                .hasCauseInstanceOf(NullPointerException.class)
                .hasMessageContaining("job cron is null");
    }

    @Test
    void givingNullJobTemplate_callCreate_shouldThrowOperationException() {
        assertThatThrownBy(() -> {
            var job = getSimpleValidJob();
            job.setTemplate(null);
            this.service.create(job);
        }).isInstanceOf(JobOperationException.class)
                .hasCauseInstanceOf(NullPointerException.class)
                .hasMessageContaining("job template is null");
    }


    @Test
    void givenASimpleJobModel_callCreate_createdJobShouldBeSame() {
        var validJob = getSimpleValidJob();

        var createdJob = service.create(validJob);


        Assertions.assertThat(createdJob)
                .isNotNull()
                .hasFieldOrPropertyWithValue("name", validJob.getName())
                .hasFieldOrPropertyWithValue("status", JobStatusEnum.DISABLE)
                .hasFieldOrPropertyWithValue("cron", CronModel.EVERY_MINUTES)
                .hasFieldOrPropertyWithValue("template", validJob.getTemplate())
        ;

        Assertions.assertThat(createdJob.getId())
                .isNotNull()
                .isGreaterThan(0L);

        Assertions.assertThat(createdJob.getTemplate().getId())
                .isNotNull()
                .isGreaterThan(0L);

        Assertions.assertThat(createdJob.getTemplate().getJobModel())
                .isNotNull()
                .isEqualTo(createdJob);

    }

    private JobModel getSimpleValidJob() {
        var job = new JobModel();
        job.setName("Valid Job");
        job.setTemplate(new RestJobTemplateModel());
        return job;
    }
}
