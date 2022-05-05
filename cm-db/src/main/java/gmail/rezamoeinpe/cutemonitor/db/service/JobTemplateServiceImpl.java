package gmail.rezamoeinpe.cutemonitor.db.service;

import gmail.rezamoeinpe.cutemonitor.db.entity.DBFunctionJobTemplateEntity;
import gmail.rezamoeinpe.cutemonitor.db.entity.JobTemplateEntity;
import gmail.rezamoeinpe.cutemonitor.db.entity.RestJobTemplateEntity;
import gmail.rezamoeinpe.cutemonitor.db.repository.DBFunctionJobTemplateRepository;
import gmail.rezamoeinpe.cutemonitor.db.repository.RestJobTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobTemplateServiceImpl implements JobTemplateService {
    private final RestJobTemplateRepository restJobTemplateRepository;
    private final DBFunctionJobTemplateRepository dbFunctionJobTemplateRepository;

    @Override
    public JobTemplateEntity create(JobTemplateEntity entity) {
        if (entity == null) return null;
        if (entity instanceof RestJobTemplateEntity)
            return restJobTemplateRepository.save((RestJobTemplateEntity) entity);

        if (entity instanceof DBFunctionJobTemplateEntity)
            return dbFunctionJobTemplateRepository.save((DBFunctionJobTemplateEntity) entity);

        return null;
    }

}
