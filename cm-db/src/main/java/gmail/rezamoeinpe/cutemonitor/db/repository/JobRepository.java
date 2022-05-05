package gmail.rezamoeinpe.cutemonitor.db.repository;

import gmail.rezamoeinpe.cutemonitor.db.entity.JobEntity;
import gmail.rezamoeinpe.cutemonitor.domain._publics.enums.JobStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Long> {

    @Query("select j from JobEntity j where j.status = ?1")
    List<JobEntity> findByStatus(@NonNull JobStatusEnum status);


}
