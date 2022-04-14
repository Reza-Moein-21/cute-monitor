package gmail.rezamoeinpe.cutemonitor.db.entity;

import gmail.rezamoeinpe.cutemonitor.db.constant.EntityConstant;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = EntityConstant.JobTemplateEntityConstant.TABLE_NAME)
public abstract class JobTemplateEntity extends AuditableEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = EntityConstant.JobTemplateEntityConstant.PRIMARY_KEY_NAME, nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "FK_JOB")
    private JobEntity job;

}
