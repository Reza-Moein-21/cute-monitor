package gmail.rezamoeinpe.cutemonitor.db.enums;

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
