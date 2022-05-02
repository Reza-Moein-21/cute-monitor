package gmail.rezamoeinpe.cutemonitor.db.mapper;

import java.util.List;

public interface BaseEntityMapper<E, M> {

    E modelToEntity(M model);

    M entityToModel(E entity);

    List<E> modelsToEntities(M... models);

    List<E> modelsToEntities(List<M> models);

    List<M> entitiesToModels(E... entities);

    List<M> entitiesToModels(List<E> entities);


}
