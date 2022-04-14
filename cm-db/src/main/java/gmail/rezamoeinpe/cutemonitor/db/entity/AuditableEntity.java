package gmail.rezamoeinpe.cutemonitor.db.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@MappedSuperclass
@Access(AccessType.FIELD)
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableEntity<ID extends Serializable> extends BaseEntity<ID> {

    @CreatedBy
    @Column(name = "CREATED_BY", nullable = false)
    private String createdBy;

    @CreatedDate
    @Column(name = "CREATED_TIME", nullable = false)
    private LocalDateTime createdTime;

    @LastModifiedBy
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    @LastModifiedDate
    @Column(name = "MODIFIED_TIME")
    private LocalDateTime modifiedTime;

    @Version
    @Column(name = "VERSION")
    private Integer version;
}
