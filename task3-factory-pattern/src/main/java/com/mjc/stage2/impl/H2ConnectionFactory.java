package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2ConnectionFactory implements ConnectionFactory {
    private static final Logger logger = LoggerFactory.getLogger(H2ConnectionFactory.class);

    private H2Properties props;

    public H2ConnectionFactory() {
        props = new H2Properties();
    }

    @Override
    public Connection createConnection() {
        props.load();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(props.getUrl(), props.getUser(), props.getPassword());
        } catch (SQLException e) {
            logger.error("Cannot create connection", e);
        }
        return connection;
    }
}

