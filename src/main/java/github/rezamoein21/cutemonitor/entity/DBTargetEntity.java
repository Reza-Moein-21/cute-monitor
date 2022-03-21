package github.rezamoein21.cutemonitor.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class DBTargetEntity extends TargetEntity {

    private String functionName;

}
