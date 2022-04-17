module gmail.rezamoeinpe.cutemonitor.app {
    requires gmail.rezamoeinpe.cutemonitor.core;

    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.web;

    opens gmail.rezamoeinpe.cutemonitor.app to spring.core, spring.beans, spring.context;

}