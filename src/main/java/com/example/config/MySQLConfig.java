package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySQLConfig {

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.username}")
    private String userName;

    @Value("${db.password}")
    private String password;

    @Value("${jdbc.driverClassName}")
    private String jdbcClassName;

    @Value("${hibernate.dialect}")
    private String dialect;

    @Value("${hibernate.show_sql}")
    private String showSql;

    @Value("${hibernate.format_sql}")
    private String formatSql;

    @Value("${hibernate.create_mode}")
    private String createMode;

    @Value("${hibernate.connection.pool.class}")
    private String connectionPoolClass;

    @Value("${hibernate.connection.pool.min.connections}")
    private String minConn;

    @Value("${hibernate.connection.pool.max.connections}")
    private String maxConn;

    @Value("${hibernate.connection.pool.timeout}")
    private String timeout;

    @Value("${hibernate.connection.pool.max.statements}")
    private String maxStatements;

    @Value("${generateMLTables}")
    private String generateMLTables;

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJdbcClassName() {
        return jdbcClassName;
    }

    public void setJdbcClassName(String jdbcClassName) {
        this.jdbcClassName = jdbcClassName;
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public String getShowSql() {
        return showSql;
    }

    public void setShowSql(String showSql) {
        this.showSql = showSql;
    }

    public String getFormatSql() {
        return formatSql;
    }

    public void setFormatSql(String formatSql) {
        this.formatSql = formatSql;
    }

    public String getCreateMode() {
        return createMode;
    }

    public void setCreateMode(String createMode) {
        this.createMode = createMode;
    }

    public String getConnectionPoolClass() {
        return connectionPoolClass;
    }

    public void setConnectionPoolClass(String connectionPoolClass) {
        this.connectionPoolClass = connectionPoolClass;
    }

    public String getMinConn() {
        return minConn;
    }

    public void setMinConn(String minConn) {
        this.minConn = minConn;
    }

    public String getMaxConn() {
        return maxConn;
    }

    public void setMaxConn(String maxConn) {
        this.maxConn = maxConn;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getMaxStatements() {
        return maxStatements;
    }

    public void setMaxStatements(String maxStatements) {
        this.maxStatements = maxStatements;
    }

    public String getGenerateMLTables() {
        return generateMLTables;
    }

    public void setGenerateMLTables(String generateMLTables) {
        this.generateMLTables = generateMLTables;
    }

}
