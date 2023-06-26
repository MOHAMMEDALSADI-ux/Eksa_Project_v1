package com.example.DailyCheck.connection;

import com.example.DailyCheck.startCycle.PropertiesCache;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

    private static HikariDataSource dataSource;
    private static JdbcTemplate jdbcTemplate;


    static {
        HikariConfig config = new HikariConfig();
        Properties dataSourceProperties  = new Properties();
        dataSourceProperties.setProperty("prepStmtCacheSize",PropertiesCache.getProperty("dataSource.prepStmtCacheSize"));


        config.setJdbcUrl(PropertiesCache.getProperty("uatjdbcUrl"));
        config.setUsername(PropertiesCache.getProperty("dataSource.user"));
        config.setPassword(PropertiesCache.getProperty("dataSource.password"));
        config.setMaximumPoolSize(Integer.parseInt(PropertiesCache.getProperty("dataSource.maximumPoolSize")));
        config.setPoolName(PropertiesCache.getProperty("dataSource.PoolName"));
        config.setAutoCommit(Boolean.parseBoolean(PropertiesCache.getProperty("dataSource.elideSetAutoCommits")));
        config.setDataSourceProperties(dataSourceProperties);

        dataSource = new HikariDataSource(config);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    public static JdbcTemplate getJdbcTemplate() { // Method For get JDBCTemplate with DataSource
        if (jdbcTemplate == null){
            jdbcTemplate = new JdbcTemplate(dataSource);
        }
        return jdbcTemplate;
    }



}
