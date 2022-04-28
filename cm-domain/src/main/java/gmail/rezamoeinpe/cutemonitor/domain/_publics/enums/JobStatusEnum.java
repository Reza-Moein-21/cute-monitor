package gmail.rezamoeinpe.cutemonitor.domain._publics.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum JobStatusEnum {
    ACTIVE("ACT"), INACTIVE("INACT"),
    DISABLE("DIS"),
    ;
    private final String code;
}
