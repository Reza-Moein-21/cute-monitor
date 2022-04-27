package gmail.rezamoeinpe.cutemonitor.core.model;

import lombok.Data;

@Data
public class JobModel {
    private String name;
    private CronModel cron;
}
