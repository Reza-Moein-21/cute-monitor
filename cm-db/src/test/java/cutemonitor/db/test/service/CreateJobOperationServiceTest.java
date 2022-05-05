package cutemonitor.db.test.service;

import gmail.rezamoeinpe.cutemonitor.db.CuteMonitorDBModule;
import gmail.rezamoeinpe.cutemonitor.db._public.exception.JobOperationException;
import gmail.rezamoeinpe.cutemonitor.db._public.service.JobOperationService;
import gmail.rezamoeinpe.cutemonitor.domain._publics.CronModel;
import gmail.rezamoeinpe.cutemonitor.domain._publics.JobModel;
import gmail.rezamoeinpe.cutemonitor.domain._publics.RestJobTemplateModel;
import gmail.rezamoeinpe.cutemonitor.domain._publics.enums.JobStatusEnum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@ContextConfiguration(classes = CuteMonitorDBModule.class)
class CreateJobOperationServiceTest {

    private static final PageRequest DEFAULT_PAGE_REQUEST = PageRequest.ofSize(10);
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
                .hasFieldOrPropertyWithValue("template", createdJob.getTemplate())
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

    @Test
    void givingSimpleJob_callCreateAndSearch_shouldExactIncludeInSearchResult() {
        var simpleValidJob = getSimpleValidJob();

        var createdJob = service.create(simpleValidJob);

        var searchResult = service.search(simpleValidJob, DEFAULT_PAGE_REQUEST);
        assertThat(searchResult.getTotalElements()).isEqualTo(0);

        searchResult = service.search(createdJob, DEFAULT_PAGE_REQUEST);
        assertThat(searchResult)
                .filteredOn(jobModel -> jobModel.equals(createdJob))
                .hasSize(1);
    }

    @Test
    void givingSimpleJobMultiply_callCreateAndSearch_shouldExactIncludeInSearchResult() {
        var simpleValidJob = getSimpleValidJob();

        var createdJob = service.create(simpleValidJob);
        var createdJob2 = service.create(simpleValidJob);
        var createdJob3 = service.create(simpleValidJob);

        var searchResult = service.search(DEFAULT_PAGE_REQUEST);
        assertThat(searchResult.getTotalElements())
                .isEqualTo(3);
    }

    private JobModel getSimpleValidJob() {
        var job = new JobModel();
        job.setName("Valid Job");
        job.setTemplate(new RestJobTemplateModel());
        return job;
    }
}
