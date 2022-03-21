package github.rezamoein21.cutemonitor.service.impl;

import github.rezamoein21.cutemonitor.entity.RESTTargetEntity;
import github.rezamoein21.cutemonitor.entity.TargetExecutorEntity;
import github.rezamoein21.cutemonitor.enums.ExecutionStatus;
import github.rezamoein21.cutemonitor.model.ExecutionResult;
import github.rezamoein21.cutemonitor.service.TargetExecutionService;

import java.time.LocalDateTime;
import java.util.function.Consumer;

public class TargetExecutionServiceImpl implements TargetExecutionService {

    public TargetExecutorEntity createRESTExecution(RESTTargetEntity restTarget, String cronExpression) {
        var executor = new TargetExecutorEntity();
        executor.setId(-1L);
        executor.setTarget(restTarget);
        executor.setCronExpression(cronExpression);
        return executor;
    }

    @Override
    public void start(TargetExecutorEntity executor, Consumer<ExecutionResult> onExecute) {
        var er = new ExecutionResult();
        er.setStatus(ExecutionStatus.RUNNING);
        er.setStartTime(LocalDateTime.now());
        onExecute.accept(er);
    }

    @Override
    public void stop(Long executorId, Consumer<ExecutionResult> onStop) {
        var er = new ExecutionResult();
        er.setStatus(ExecutionStatus.STOPPED);
        er.setStopTime(LocalDateTime.now());
        onStop.accept(er);
    }
}
