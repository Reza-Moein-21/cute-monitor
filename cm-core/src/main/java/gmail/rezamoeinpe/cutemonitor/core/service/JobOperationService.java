package gmail.rezamoeinpe.cutemonitor.core.service;

import gmail.rezamoeinpe.cutemonitor.core.model.JobModel;

import java.util.List;

public interface JobOperationService {

    void create(JobModel job);

    List<JobModel> search(JobModel example);
}
