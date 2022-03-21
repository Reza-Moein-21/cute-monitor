package github.rezamoein21.cutemonitor.model;

import github.rezamoein21.cutemonitor.enums.ExecutionStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExecutionResult {
    private LocalDateTime startTime;
    private LocalDateTime stopTime;
    private ExecutionStatus status;
}
