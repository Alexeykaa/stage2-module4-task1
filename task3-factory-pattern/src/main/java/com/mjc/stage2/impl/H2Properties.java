package com.mjc.stage2.impl;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class H2Properties {
    private static final Logger logger = LoggerFactory.getLogger(H2Properties.class);
    private static final String JDBC_DRIVER_PROPERTY = "jdbc_driver";
    private static final String DB_URL_PROPERTY = "db_url";
    private static final String DB_USER_PROPERTY = "user";
    private static final String DB_PASSWORD_PROPERTY = "password";
    public static final String DB_PROPERTIES_FILE_NAME = "h2database.properties";

    private String fileName;
    private Properties prop;

    public H2Properties() {
        fileName = DB_PROPERTIES_FILE_NAME;
    }

    public void load() {
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream(fileName));
        } catch (IOException e) {
            logger.error("Cannot load file property: {}", fileName, e);
        }
        this.prop = properties;
    }

    public String getJdbcDriver() {
        return prop.getProperty(JDBC_DRIVER_PROPERTY);
    }

    public String getUrl() {
        return prop.getProperty(DB_URL_PROPERTY);
    }

    public String getUser() {
        return prop.getProperty(DB_USER_PROPERTY);
    }

    public String getPassword() {
        return prop.getProperty(DB_PASSWORD_PROPERTY);
    }
}