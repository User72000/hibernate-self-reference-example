package com.example.service;

import com.example.config.MySQLConfig;
import com.example.constants.ApplicationConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Properties;

@Service
public class HibernateService {

    @Autowired
    private MySQLConfig sqldbConfig;

    private static final Logger LOG = LogManager.getLogger();

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(ApplicationConstants.HIBERNATE_PACKAGE_SCAN);
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put(ApplicationConstants.HIBERNATE_DIALECT, sqldbConfig.getDialect());
        properties.put(ApplicationConstants.HIBERNATE_SHOW_SQL, sqldbConfig.getShowSql());
        properties.put(ApplicationConstants.HIBERNATE_FORMAT_SQL, sqldbConfig.getFormatSql());
        if (Boolean.parseBoolean(sqldbConfig.getGenerateMLTables())) {
            properties.put(ApplicationConstants.HIBERNATE_DDL_MODE, sqldbConfig.getCreateMode());
        }
        properties.put(ApplicationConstants.HIBERNATE_CP_PROVIDER_CLASS,
                sqldbConfig.getConnectionPoolClass());
        properties.put(ApplicationConstants.HIBERNATE_CP_MIN_SIZE,
                sqldbConfig.getMinConn());
        properties.put(ApplicationConstants.HIBERNATE_CP_MAX_SIZE,
                sqldbConfig.getMaxConn());
        properties.put(ApplicationConstants.HIBERNATE_CP_TIMEOUT, sqldbConfig.getTimeout());
        properties.put(ApplicationConstants.HIBERNATE_CP_MAX_STATEMENTS,
                sqldbConfig.getMaxStatements());
        return properties;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(sqldbConfig.getJdbcClassName());
        dataSource.setUrl(sqldbConfig.getDbUrl());
        dataSource.setUsername(sqldbConfig.getUserName());
        dataSource.setPassword(sqldbConfig.getPassword());
        return dataSource;
    }

    public static void closeSilently(Session session) {
        try {
            if (session != null)
                session.close();
            session = null;
        } catch (HibernateException e) {
            LOG.error("#### Error while closing hibernate session #####");
        }
    }

}