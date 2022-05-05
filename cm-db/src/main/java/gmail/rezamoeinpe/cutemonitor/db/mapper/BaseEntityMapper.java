package gmail.rezamoeinpe.cutemonitor.db.mapper;

import gmail.rezamoeinpe.cutemonitor.db.entity.BaseEntity;
import gmail.rezamoeinpe.cutemonitor.domain._publics.BaseModel;

import java.io.Serializable;
import java.util.List;

public interface BaseEntityMapper<E extends BaseEntity<ID>, M extends BaseModel, ID extends Serializable> {

    E clone(E entity);

    M clone(M model);

    E modelToEntity(M model);

    M entityToModel(E entity);

    List<E> modelsToEntities(M... models);

    List<E> modelsToEntities(List<M> models);

    List<M> entitiesToModels(E... entities);

    List<M> entitiesToModels(List<E> entities);


}
