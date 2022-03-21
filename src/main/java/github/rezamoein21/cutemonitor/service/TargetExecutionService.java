package github.rezamoein21.cutemonitor.service;

import github.rezamoein21.cutemonitor.entity.RESTTargetEntity;
import github.rezamoein21.cutemonitor.entity.TargetExecutorEntity;
import github.rezamoein21.cutemonitor.model.ExecutionResult;

import java.util.function.Consumer;

public interface TargetExecutionService {
    TargetExecutorEntity createRESTExecution(RESTTargetEntity restTarget, String cronExpression);

    void start(TargetExecutorEntity executor, Consumer<ExecutionResult> onExecute);

    void stop(Long executorId, Consumer<ExecutionResult> onStop);
}
