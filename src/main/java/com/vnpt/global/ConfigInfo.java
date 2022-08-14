package com.vnpt.global;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.experimental.UtilityClass;

import java.io.File;

/**
 * @author HuyDD24
 * @date 8/1/2022
 */

@UtilityClass
public class ConfigInfo {

    private static Config config = ConfigFactory.parseFile(new File("conf.properties"));
    public static final int SERVICE_PORT = config.getInt("service.port");

    //-----------------------------------------------------------------------------------------------
    public static final String MYSQL_DRIVER_CLASS_NAME = config.getString("db.driver.name");
    public static final String MYSQL_JDBC_URL = config.getString("db.url");
    public static final String MYSQL_USERNAME = config.getString("db.username");
    public static final String MYSQL_PASSWORD = config.getString("db.password");
    public static final int MYSQL_MAXIMUM_POOL_SIZE = config.getInt("maximum.pool.size");
    public static final int MYSQL_MINIMUM_IDLE_SIZE = config.getInt("minimum.idle.size");



    //---------------------------------------------------------------------------------------
    public static final int RESPONSE_CACHE_INFO_SIZE = config.getInt("response.cache.info.size");
    public static final int RESPONSE_CACHE_INFO_EXPIRE = config.getInt("response.cache.info.expire");
}
