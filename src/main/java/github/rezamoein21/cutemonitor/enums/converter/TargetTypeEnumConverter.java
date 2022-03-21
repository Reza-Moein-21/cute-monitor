package github.rezamoein21.cutemonitor.enums.converter;

import github.rezamoein21.cutemonitor.enums.TargetTypeEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter
public class TargetTypeEnumConverter implements AttributeConverter<TargetTypeEnum, String> {

    @Override
    public String convertToDatabaseColumn(TargetTypeEnum targetTypeEnum) {
        return targetTypeEnum.getCode();
    }

    @Override
    public TargetTypeEnum convertToEntityAttribute(String code) {
        return Arrays.stream(TargetTypeEnum.values())
                .filter(t -> t.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Code not found"));
    }
}
