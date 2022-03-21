package github.rezamoein21.cutemonitor.service;

import github.rezamoein21.cutemonitor.entity.RESTTargetEntity;
import github.rezamoein21.cutemonitor.entity.TargetExecutorEntity;

public class TargetExecutionService {

    public TargetExecutorEntity createRESTExecution(RESTTargetEntity restTarget, String cronExpression) {
        var executor = new TargetExecutorEntity();
        executor.setId(-1L);
        executor.setTarget(restTarget);
        executor.setCronExpression(cronExpression);
        return executor;
    }
}
