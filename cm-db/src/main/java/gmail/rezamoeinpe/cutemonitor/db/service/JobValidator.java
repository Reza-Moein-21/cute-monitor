package gmail.rezamoeinpe.cutemonitor.db.service;

import gmail.rezamoeinpe.cutemonitor.db._publics.exception.JobOperationException;
import gmail.rezamoeinpe.cutemonitor.domain._publics.JobModel;
import org.springframework.stereotype.Component;

@Component
public class JobValidator {

    public void validateForCreate(JobModel job) throws JobOperationException {
        if (job == null) throw new JobOperationException("job model is null", new NullPointerException());
        if (job.getName() == null) throw new JobOperationException("job name is null", new NullPointerException());
        if (job.getCron() == null) throw new JobOperationException("job cron is null", new NullPointerException());
    }
}
