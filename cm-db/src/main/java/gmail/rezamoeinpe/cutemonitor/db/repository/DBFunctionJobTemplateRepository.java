package gmail.rezamoeinpe.cutemonitor.db.repository;

import gmail.rezamoeinpe.cutemonitor.db.entity.DBFunctionJobTemplateEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBFunctionJobTemplateRepository extends PagingAndSortingRepository<DBFunctionJobTemplateEntity, Long> {
}
