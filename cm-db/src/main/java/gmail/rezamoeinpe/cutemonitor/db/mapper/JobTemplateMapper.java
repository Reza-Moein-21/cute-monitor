package gmail.rezamoeinpe.cutemonitor.db.mapper;

import gmail.rezamoeinpe.cutemonitor.db.entity.DBFunctionJobTemplateEntity;
import gmail.rezamoeinpe.cutemonitor.db.entity.JobTemplateEntity;
import gmail.rezamoeinpe.cutemonitor.db.entity.RestJobTemplateEntity;
import gmail.rezamoeinpe.cutemonitor.domain._publics.DBFunctionJobTemplateModel;
import gmail.rezamoeinpe.cutemonitor.domain._publics.JobTemplateModel;
import gmail.rezamoeinpe.cutemonitor.domain._publics.RestJobTemplateModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface JobTemplateMapper extends BaseEntityMapper<JobTemplateEntity, JobTemplateModel> {

    @Override
    default JobTemplateModel entityToModel(JobTemplateEntity entity) {
        if (entity == null) return null;

        if (entity instanceof DBFunctionJobTemplateEntity)
            return Mappers.getMapper(DBFunctionJobTemplateMapper.class).entityToModel((DBFunctionJobTemplateEntity) entity);

        if (entity instanceof RestJobTemplateEntity)
            return Mappers.getMapper(RestJobTemplateMapper.class).entityToModel((RestJobTemplateEntity) entity);

        throw new ClassCastException("Can't cast abstract jobTemplateEntity to any valid implementation");
    }

    @Override
    default JobTemplateEntity modelToEntity(JobTemplateModel model) {
        if (model == null) return null;

        if (model instanceof DBFunctionJobTemplateModel)
            return Mappers.getMapper(DBFunctionJobTemplateMapper.class).modelToEntity((DBFunctionJobTemplateModel) model);

        if (model instanceof RestJobTemplateModel)
            return Mappers.getMapper(RestJobTemplateMapper.class).modelToEntity((RestJobTemplateModel) model);

        throw new ClassCastException("Can't cast abstract jobTemplateModel to any valid implementation");
    }
}
