package gmail.rezamoeinpe.cutemonitor.db.constant;

public final class EntityConstant {


    private static final String TABLE_PREFIX = "CTMR_";
    private static final String PK_PREFIX = "PK_";
    private static final String FK_PREFIX = "FK_";

    public static final class JobEntityConstant {
        private static final String NAME = "JOB";
        public static final String TABLE_NAME = TABLE_PREFIX + NAME;
        public static final String PRIMARY_KEY_NAME = PK_PREFIX + NAME;
    }

    public static final class JobTemplateEntityConstant {
        private static final String NAME = "JOB_TEMPLATE";
        public static final String TABLE_NAME = TABLE_PREFIX + NAME;
        public static final String PRIMARY_KEY_NAME = PK_PREFIX + NAME;
    }


    public static final class DBFunctionJobTemplateEntityConstant {
        private static final String NAME = "DB_FN_JOB_TEMPLATE";
        public static final String TABLE_NAME = TABLE_PREFIX + NAME;
        public static final String PRIMARY_KEY_NAME = PK_PREFIX + NAME;
    }

    public static final class RestJobTemplateEntityConstant {
        private static final String NAME = "REST_JOB_TEMPLATE";
        public static final String TABLE_NAME = TABLE_PREFIX + NAME;
        public static final String PRIMARY_KEY_NAME = PK_PREFIX + NAME;
    }


}
