package gmail.rezamoeinpe.cutemonitor.db._public.service;


import gmail.rezamoeinpe.cutemonitor.domain._publics.JobModel;

import java.util.List;

public interface JobOperationService {

    JobModel create(JobModel job);

    List<JobModel> search(JobModel example);
}
