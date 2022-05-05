package gmail.rezamoeinpe.cutemonitor.domain._publics;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public abstract class BaseModel<ID extends Serializable> {
    private ID id;
    private String createdBy = "NONE";
    private LocalDateTime createdTime = LocalDateTime.now();
    private String modifiedBy = "NONE";
    private LocalDateTime modifiedTime = LocalDateTime.now();
}
