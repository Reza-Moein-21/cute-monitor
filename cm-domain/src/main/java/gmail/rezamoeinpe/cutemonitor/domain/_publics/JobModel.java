package gmail.rezamoeinpe.cutemonitor.domain._publics;

import gmail.rezamoeinpe.cutemonitor.domain._publics.enums.JobStatusEnum;
import lombok.Data;

@Data
public class JobModel {
    private Long id;
    private String name;
    private JobStatusEnum status = JobStatusEnum.DISABLE;
    private CronModel cron = CronModel.EVERY_MINUTES;
    private JobTemplateModel template;
}
