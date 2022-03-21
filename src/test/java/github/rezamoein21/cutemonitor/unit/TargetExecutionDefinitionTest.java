package github.rezamoein21.cutemonitor.unit;

import github.rezamoein21.cutemonitor.entity.RESTTargetEntity;
import github.rezamoein21.cutemonitor.entity.TargetExecutorEntity;
import github.rezamoein21.cutemonitor.service.TargetExecutionService;
import github.rezamoein21.cutemonitor.service.impl.TargetExecutionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TargetExecutionDefinitionTest {

    private TargetExecutionService service;

    @BeforeEach
    void setUp() {
        this.service = new TargetExecutionServiceImpl();
    }

    @Test
    void defineRESTTargetExecution() {
        var restTarget = new RESTTargetEntity();
        var cronExpression = "";
        TargetExecutorEntity executor = this.service.createRESTExecution(restTarget, cronExpression);
        assertNotNull(executor.getId());
        assertEquals(restTarget, executor.getTarget());
        assertEquals(cronExpression, executor.getCronExpression());
    }
}
