package github.rezamoein21.cutemonitor.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class TargetEntity {

    private String name;
}
