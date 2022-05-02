package gmail.rezamoeinpe.cutemonitor.db.mapper;

import gmail.rezamoeinpe.cutemonitor.db.entity.JobEntity;
import gmail.rezamoeinpe.cutemonitor.domain._publics.JobModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobMapper extends BaseEntityMapper<JobEntity, JobModel> {
}
