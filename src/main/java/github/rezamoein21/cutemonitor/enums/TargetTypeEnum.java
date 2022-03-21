package github.rezamoein21.cutemonitor.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TargetTypeEnum {
    DB_FUNCTION("fn"), REST("rest");
    private final String code;

}
