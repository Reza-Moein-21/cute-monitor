package gmail.rezamoeinpe.cutemonitor.db.service;

import gmail.rezamoeinpe.cutemonitor.db._public.service.JobOperationService;
import gmail.rezamoeinpe.cutemonitor.db.mapper.JobMapper;
import gmail.rezamoeinpe.cutemonitor.domain._publics.JobModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobOperationServiceImpl implements JobOperationService {
    private final JobValidator validator;
    private final JobMapper mapper;

    private final Set<JobModel> jobStore = new HashSet<>();

    @Override
    public JobModel create(JobModel job) {
        validator.validateForCreate(job);

        var newJob = mapper.clone(job);
        newJob.setId(123L);
        if (newJob.getTemplate() != null) {
            newJob.getTemplate().setId(234L);
            newJob.getTemplate().setJobModel(newJob);
        }
        jobStore.add(newJob);
        return newJob;
    }

    @Override
    public List<JobModel> search(JobModel example) {
        return jobStore.stream().filter(jobModel -> jobModel.equals(example)).collect(Collectors.toList());
    }
}
