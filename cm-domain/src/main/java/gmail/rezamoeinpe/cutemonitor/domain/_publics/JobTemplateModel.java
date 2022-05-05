package gmail.rezamoeinpe.cutemonitor.domain._publics;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JobTemplateModel extends BaseModel<Long> {
    private Long id;

    @ToString.Exclude
    private JobModel job;
}
