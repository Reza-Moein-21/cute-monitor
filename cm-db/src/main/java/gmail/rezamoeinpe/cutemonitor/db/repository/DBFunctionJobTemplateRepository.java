package gmail.rezamoeinpe.cutemonitor.db.repository;

import gmail.rezamoeinpe.cutemonitor.db.entity.DBFunctionJobTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBFunctionJobTemplateRepository extends JpaRepository<DBFunctionJobTemplateEntity, Long> {
}
