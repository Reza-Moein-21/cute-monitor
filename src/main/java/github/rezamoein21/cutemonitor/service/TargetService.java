package github.rezamoein21.cutemonitor.service;

import github.rezamoein21.cutemonitor.entity.DBTargetEntity;
import github.rezamoein21.cutemonitor.entity.RESTTargetEntity;

public interface TargetService {
    DBTargetEntity createDBFunctionTarget(String targetName, String functionName);

    RESTTargetEntity createRESTTarget(String targetName, String endPoint);
}
