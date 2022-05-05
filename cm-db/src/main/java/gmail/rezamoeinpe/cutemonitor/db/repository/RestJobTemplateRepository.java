package gmail.rezamoeinpe.cutemonitor.db.repository;

import gmail.rezamoeinpe.cutemonitor.db.entity.RestJobTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestJobTemplateRepository extends JpaRepository<RestJobTemplateEntity, Long> {
}
