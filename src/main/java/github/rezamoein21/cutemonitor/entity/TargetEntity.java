package github.rezamoein21.cutemonitor.entity;

import github.rezamoein21.cutemonitor.enums.TargetTypeEnum;
import github.rezamoein21.cutemonitor.enums.converter.TargetTypeEnumConverter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Convert;
import javax.persistence.Inheritance;

import static javax.persistence.InheritanceType.JOINED;

@Getter
@Setter
@Inheritance(strategy = JOINED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TargetEntity {

    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    @Convert(converter = TargetTypeEnumConverter.class)
    private TargetTypeEnum targetType;
}
