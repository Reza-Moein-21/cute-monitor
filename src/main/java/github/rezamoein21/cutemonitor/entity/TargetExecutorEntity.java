package github.rezamoein21.cutemonitor.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TargetExecutorEntity {

    @Id
    private Long id;

    private String cronExpression;

    @OneToOne(fetch = LAZY)
    private TargetEntity target;


}
