package gmail.rezamoeinpe.cutemonitor.domain._publics;

import lombok.Data;

@Data
public class JobModel {
    private Long id;
    private String name;
    private CronModel cron;
}
