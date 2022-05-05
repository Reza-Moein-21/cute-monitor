package gmail.rezamoeinpe.cutemonitor.db.service;

import gmail.rezamoeinpe.cutemonitor.db._public.service.JobOperationService;
import gmail.rezamoeinpe.cutemonitor.db.entity.JobEntity;
import gmail.rezamoeinpe.cutemonitor.db.entity.JobTemplateEntity;
import gmail.rezamoeinpe.cutemonitor.db.mapper.JobMapper;
import gmail.rezamoeinpe.cutemonitor.db.repository.JobRepository;
import gmail.rezamoeinpe.cutemonitor.domain._publics.JobModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobOperationServiceImpl implements JobOperationService {
    private final JobValidator validator;
    private final JobMapper mapper;
    private final JobRepository repository;

    private final JobTemplateService jobTemplateService;

    @Override
    public JobModel create(JobModel job) {
        validator.validateForCreate(job);

        JobEntity newJobEntity = mapper.modelToEntity(job);
        JobTemplateEntity savedJobTemplate = jobTemplateService.create(newJobEntity.getTemplate());
        newJobEntity.setTemplate(savedJobTemplate);
        JobEntity saveEntity = repository.save(newJobEntity);

        return mapper.entityToModel(saveEntity);
    }

    @Override
    public Page<JobModel> search(JobModel example, PageRequest pageRequest) {
        var matcher = ExampleMatcher
                .matchingAll()
                .withIgnorePaths("template");
        return repository.findAll(Example.of(mapper.modelToEntity(example), matcher), pageRequest).map(mapper::entityToModel);
    }

    @Override
    public Page<JobModel> search(PageRequest pageRequest) {
        return repository.findAll(pageRequest).map(mapper::entityToModel);
    }

}
