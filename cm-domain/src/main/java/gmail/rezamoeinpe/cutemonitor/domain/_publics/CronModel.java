package gmail.rezamoeinpe.cutemonitor.domain._publics;

import lombok.Data;

@Data
public class CronModel {

    public static final CronModel EVERY_MINUTES = CronModel.of(0, 0, 1);

    public static CronModel of(int days, int hours, int minutes) {
        return new CronModel();
    }


}
