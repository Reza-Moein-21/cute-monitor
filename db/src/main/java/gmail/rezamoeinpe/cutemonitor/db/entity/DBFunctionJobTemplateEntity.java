package gmail.rezamoeinpe.cutemonitor.db.entity;

import gmail.rezamoeinpe.cutemonitor.db.constant.EntityConstant;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@ToString
@Table(name = EntityConstant.DBFunctionJobTemplateEntityConstant.TABLE_NAME)
public class DBFunctionJobTemplateEntity extends JobTemplateEntity {
}
