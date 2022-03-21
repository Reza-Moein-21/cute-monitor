package github.rezamoein21.cutemonitor.service.impl;

import github.rezamoein21.cutemonitor.entity.DBTargetEntity;
import github.rezamoein21.cutemonitor.entity.RESTTargetEntity;
import github.rezamoein21.cutemonitor.service.TargetService;

public class TargetServiceImpl implements TargetService {

    @Override
    public DBTargetEntity createDBFunctionTarget(String targetName, String functionName) {
        var dbTarget = new DBTargetEntity();
        dbTarget.setId(-1L);
        dbTarget.setName(targetName);
        dbTarget.setFunctionName(functionName);
        return dbTarget;
    }

    @Override
    public RESTTargetEntity createRESTTarget(String targetName, String endPoint) {
        var restTarget = new RESTTargetEntity();
        restTarget.setId(-1L);
        restTarget.setName(targetName);
        restTarget.setEndPoint(endPoint);
        return restTarget;
    }
}
