package gmail.rezamoeinpe.cutemonitor.domain._publics;

import gmail.rezamoeinpe.cutemonitor.domain._publics.enums.JobStatusEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JobModel extends BaseModel<Long> {
    private Long id;
    private String name;
    private JobStatusEnum status = JobStatusEnum.DISABLE;
    private CronModel cron = CronModel.EVERY_MINUTES;
    private JobTemplateModel template;
}
