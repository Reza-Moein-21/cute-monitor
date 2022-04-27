package gmail.rezamoeinpe.cutemonitor.core.service.provider;

import gmail.rezamoeinpe.cutemonitor.core.exception.JobOperationException;
import gmail.rezamoeinpe.cutemonitor.core.model.JobModel;
import gmail.rezamoeinpe.cutemonitor.core.service.JobOperationService;

public class JobOperationServiceImpl implements JobOperationService {

    @Override
    public void create(JobModel job) {
        if (job == null) throw new JobOperationException("job model is null", new NullPointerException());
        if (job.getName() == null) throw new JobOperationException("job name is null", new NullPointerException());
        if (job.getCron() == null) throw new JobOperationException("job cron is null", new NullPointerException());
    }
}
