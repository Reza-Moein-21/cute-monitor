package gmail.rezamoeinpe.cutemonitor.core.service.provider;

import gmail.rezamoeinpe.cutemonitor.core.model.JobModel;
import gmail.rezamoeinpe.cutemonitor.core.service.JobOperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobOperationServiceImpl implements JobOperationService {
    private final JobValidator validator;

    @Override
    public void create(JobModel job) {
        validator.validateForCreate(job);
    }
}
