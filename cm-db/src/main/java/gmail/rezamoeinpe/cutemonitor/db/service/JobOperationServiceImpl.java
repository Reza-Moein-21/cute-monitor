package gmail.rezamoeinpe.cutemonitor.db.service;

import gmail.rezamoeinpe.cutemonitor.db._public.service.JobOperationService;
import gmail.rezamoeinpe.cutemonitor.db.mapper.JobMapper;
import gmail.rezamoeinpe.cutemonitor.domain._publics.JobModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        newJob.setId(123L + jobStore.size());
        if (newJob.getTemplate() != null) {
            newJob.getTemplate().setId(234L + jobStore.size());
            newJob.getTemplate().setJobModel(newJob);
        }
        jobStore.add(newJob);
        return newJob;
    }

    @Override
    public Page<JobModel> search(JobModel example, PageRequest pageRequest) {
        List<JobModel> items = jobStore.stream().filter(jobModel -> jobModel.equals(example)).collect(Collectors.toList());

        return toPage(items, pageRequest);
    }

    @Override
    public Page<JobModel> search(PageRequest pageRequest) {
        List<JobModel> items = new ArrayList<>(jobStore);
        return toPage(items, pageRequest);
    }

    private <T> Page<T> toPage(List<T> items, PageRequest pageRequest) {
        final int start = (int) pageRequest.getOffset();
        final int end = Math.min((start + pageRequest.getPageSize()), items.size());
        return new PageImpl<>(items.subList(start, end), pageRequest, items.size());
    }
}
