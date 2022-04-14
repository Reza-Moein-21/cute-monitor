package gmail.rezamoeinpe.cutemonitor.db.repository;

import gmail.rezamoeinpe.cutemonitor.db.entity.RestJobTemplateEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestJobTemplateRepository extends PagingAndSortingRepository<RestJobTemplateEntity, Long> {
}
