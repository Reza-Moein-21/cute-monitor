package github.rezamoein21.cutemonitor.unit;

import github.rezamoein21.cutemonitor.entity.TargetExecutorEntity;
import github.rezamoein21.cutemonitor.enums.ExecutionStatus;
import github.rezamoein21.cutemonitor.service.TargetExecutionService;
import github.rezamoein21.cutemonitor.service.impl.TargetExecutionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TargetExecutionExecuteTest {

    private TargetExecutionService executionService;

    @BeforeEach
    void setUp() {
        this.executionService = new TargetExecutionServiceImpl();
    }

    @Test
    void runMockExecuteShouldSendTheResultAsACallbackFunction() {
        var executor = new TargetExecutorEntity();

        this.executionService.start(executor, er -> {
            assertNotNull(er.getStartTime());
            assertEquals(ExecutionStatus.RUNNING, er.getStatus());
        });
    }

    @Test
    void stopMockExecutorShouldSendResultAsCallback() {
        var executorId = -1L;
        this.executionService.stop(executorId, er -> {
            assertNotNull(er.getStopTime());
            assertEquals(ExecutionStatus.STOPPED, er.getStatus());
        });
    }
}
