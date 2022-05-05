package gmail.rezamoeinpe.cutemonitor.db.mapper;

import gmail.rezamoeinpe.cutemonitor.db.entity.RestJobTemplateEntity;
import gmail.rezamoeinpe.cutemonitor.domain._publics.RestJobTemplateModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestJobTemplateMapper extends BaseEntityMapper<RestJobTemplateEntity, RestJobTemplateModel> {
}
