package com.example.constants;

public interface ApplicationConstants {

    String SPRING_PROFILE_PROPERTY = "spring.profiles.active";

    String HIBERNATE_DIALECT = "hibernate.dialect";
    String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    String HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    String HIBERNATE_PACKAGE_SCAN = "com.example.entities";
    String HIBERNATE_DDL_MODE = "hibernate.hbm2ddl.auto";
    String HIBERNATE_CP_PROVIDER_CLASS = "hibernate.connection.driver_class";// it may be "hibernate.connection.driver_class"
    String HIBERNATE_CP_MIN_SIZE = "hibernate.c3p0.min_size";
    String HIBERNATE_CP_MAX_SIZE = "hibernate.c3p0.max_size";
    String HIBERNATE_CP_TIMEOUT = "hibernate.c3p0.timeout";
    String HIBERNATE_CP_MAX_STATEMENTS = "hibernate.c3p0.max_statements";
}
