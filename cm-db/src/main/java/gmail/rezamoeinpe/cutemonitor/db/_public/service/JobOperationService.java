package gmail.rezamoeinpe.cutemonitor.db._public.service;


import gmail.rezamoeinpe.cutemonitor.domain._publics.JobModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface JobOperationService {

    JobModel create(JobModel job);

    Page<JobModel> search(JobModel example, PageRequest pageRequest);

    Page<JobModel> search(PageRequest pageRequest);
}
