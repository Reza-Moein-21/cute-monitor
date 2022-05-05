package gmail.rezamoeinpe.cutemonitor.db.entity;

import gmail.rezamoeinpe.cutemonitor.db.constant.EntityConstant;
import gmail.rezamoeinpe.cutemonitor.domain._publics.enums.JobStatusEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString(callSuper = true)
@Table(name = EntityConstant.JobEntityConstant.TABLE_NAME)
public class JobEntity extends AuditableEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = EntityConstant.JobEntityConstant.PRIMARY_KEY_NAME, nullable = false)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "STATUS")
    private JobStatusEnum status;

    @OneToOne(mappedBy = "job", fetch = FetchType.EAGER)
    private JobTemplateEntity template;


}
