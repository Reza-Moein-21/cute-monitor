open module gmail.rezamoeinpe.cutemonitor.db {
    requires static lombok;

    requires spring.context;
    requires spring.data.commons;
    requires spring.data.jpa;
    requires java.persistence;
    requires spring.core;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.tx;
    requires spring.beans;

    exports gmail.rezamoeinpe.cutemonitor.db.constant;
    exports gmail.rezamoeinpe.cutemonitor.db.entity;
    exports gmail.rezamoeinpe.cutemonitor.db.enums;
    exports gmail.rezamoeinpe.cutemonitor.db.repository;
    exports gmail.rezamoeinpe.cutemonitor.db;


}