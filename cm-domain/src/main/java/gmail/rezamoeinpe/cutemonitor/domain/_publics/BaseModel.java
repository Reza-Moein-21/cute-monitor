package gmail.rezamoeinpe.cutemonitor.domain._publics;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public abstract class BaseModel<ID extends Serializable> {
    private ID id;
}
