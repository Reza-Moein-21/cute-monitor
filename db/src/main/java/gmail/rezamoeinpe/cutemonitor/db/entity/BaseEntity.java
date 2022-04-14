package gmail.rezamoeinpe.cutemonitor.db.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public abstract class BaseEntity<ID extends Serializable> {
    private ID id;
}
