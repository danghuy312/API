package com.vnpt.factory;

import com.vnpt.global.ConfigInfo;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author HuyDD24
 * @date 8/1/2022
 */

public class SQLConnectionFactory {

    private static SQLConnectionFactory ourInstance;

    public static SQLConnectionFactory getInstance() {
        if (ourInstance == null) {
            synchronized (SQLConnectionFactory.class) {
                if (ourInstance == null) {
                    ourInstance = new SQLConnectionFactory();
                }
            }
        }
        return ourInstance;
    }

    private static HikariDataSource hikariDataSource;

    private SQLConnectionFactory() {
        HikariConfig config = new HikariConfig();
        config.setPoolName("Hikari-MySQL-Pool");
        config.setDriverClassName(ConfigInfo.MYSQL_DRIVER_CLASS_NAME);
        config.setJdbcUrl(ConfigInfo.MYSQL_JDBC_URL);
        config.setUsername(ConfigInfo.MYSQL_USERNAME);
        config.setPassword(ConfigInfo.MYSQL_PASSWORD);
        config.setMaximumPoolSize(ConfigInfo.MYSQL_MAXIMUM_POOL_SIZE);
        config.setMinimumIdle(ConfigInfo.MYSQL_MINIMUM_IDLE_SIZE);
        config.setAutoCommit(true);

        hikariDataSource = new HikariDataSource(config);
    }

    public Connection getSQLConnection() throws SQLException {
        return hikariDataSource.getConnection();
    }
}
