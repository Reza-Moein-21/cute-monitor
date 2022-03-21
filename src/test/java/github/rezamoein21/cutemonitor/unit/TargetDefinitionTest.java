package github.rezamoein21.cutemonitor.unit;

import github.rezamoein21.cutemonitor.entity.DBTargetEntity;
import github.rezamoein21.cutemonitor.entity.RESTTargetEntity;
import github.rezamoein21.cutemonitor.service.TargetService;
import github.rezamoein21.cutemonitor.service.impl.TargetServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TargetDefinitionTest {

    private TargetService targetService;

    @BeforeEach
    void setUp() {
        this.targetService = new TargetServiceImpl();
    }

    @Test
    public void newDBFunctionTargetTest() {
        var functionName = "fn_test";
        var targetName = "check_data_exist";
        DBTargetEntity target = this.targetService.createDBFunctionTarget(targetName, functionName);
        assertNotNull(target.getId());
        assertEquals(targetName, target.getName());
        assertEquals(functionName, target.getFunctionName());
    }

    @Test
    public void newRESTTargetTest() {
        var endPoint = "http://test.server/test";
        var targetName = "check-service-up";
        RESTTargetEntity target = this.targetService.createRESTTarget(targetName, endPoint);
        assertNotNull(target.getId());
        assertEquals(targetName, target.getName());
        assertEquals(endPoint, target.getEndPoint());
    }
}
