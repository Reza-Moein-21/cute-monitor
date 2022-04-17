module gmail.rezamoeinpe.cutemonitor.core {
    requires gmail.rezamoeinpe.cutemonitor.db;

    requires spring.context;
    requires spring.core;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.beans;

    opens gmail.rezamoeinpe.cutemonitor.core to spring.core, spring.beans, spring.context;

}