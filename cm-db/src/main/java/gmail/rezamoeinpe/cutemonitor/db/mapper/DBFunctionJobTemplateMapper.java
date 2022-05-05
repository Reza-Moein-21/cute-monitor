package gmail.rezamoeinpe.cutemonitor.db.mapper;

import gmail.rezamoeinpe.cutemonitor.db.entity.DBFunctionJobTemplateEntity;
import gmail.rezamoeinpe.cutemonitor.domain._publics.DBFunctionJobTemplateModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DBFunctionJobTemplateMapper extends BaseEntityMapper<DBFunctionJobTemplateEntity, DBFunctionJobTemplateModel, Long> {
}
