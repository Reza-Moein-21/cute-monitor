package gmail.rezamoeinpe.cutemonitor.db.service;

import gmail.rezamoeinpe.cutemonitor.db._public.service.JobOperationService;
import gmail.rezamoeinpe.cutemonitor.domain._publics.JobModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobOperationServiceImpl implements JobOperationService {
    private final JobValidator validator;

    @Override
    public JobModel create(JobModel job) {
        validator.validateForCreate(job);
        job.setId(123L);
        if (job.getTemplate() != null) {
            job.getTemplate().setId(234L);
            job.getTemplate().setJobModel(job);
        }
        return job;
    }

    @Override
    public List<JobModel> search(JobModel example) {
        return List.of(example);
    }
}
