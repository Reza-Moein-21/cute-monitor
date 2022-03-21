package github.rezamoein21.cutemonitor.entity;

import github.rezamoein21.cutemonitor.enums.TargetTypeEnum;
import github.rezamoein21.cutemonitor.enums.converter.TargetTypeEnumConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "target_type")
public class TargetEntity {

    private String name;

    @Column(name = "target_type")
    @Convert(converter = TargetTypeEnumConverter.class)
    private TargetTypeEnum targetType;
}
