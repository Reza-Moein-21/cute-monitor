package cutemonitor.core.test.service.operation;

import gmail.rezamoeinpe.cutemonitor.core.exception.JobOperationException;
import gmail.rezamoeinpe.cutemonitor.core.model.JobModel;
import gmail.rezamoeinpe.cutemonitor.core.service.JobOperationService;
import gmail.rezamoeinpe.cutemonitor.core.service.provider.JobOperationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CreateJobOperationServiceTest {

    private JobOperationService service;

    @BeforeEach
    void setUp() {
        this.service = new JobOperationServiceImpl();
    }

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
}
