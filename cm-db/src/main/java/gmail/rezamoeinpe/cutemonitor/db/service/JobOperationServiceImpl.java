package gmail.rezamoeinpe.cutemonitor.db.service;

import gmail.rezamoeinpe.cutemonitor.db._publics.service.JobOperationService;
import gmail.rezamoeinpe.cutemonitor.domain._publics.JobModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobOperationServiceImpl implements JobOperationService {
    private final JobValidator validator;

    @Override
    public void create(JobModel job) {
        validator.validateForCreate(job);
        job.setId(123L);
    }

    @Override
    public List<JobModel> search(JobModel example) {
        return List.of(example);
    }
}
