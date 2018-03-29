package com.littlefisher.core.mybatis.generator.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

import org.mybatis.generator.api.ConnectionFactory;
import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.internal.ObjectFactory;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

/**
 * Description: LittleFisherJdbcConnectionFactory
 *
 * Created on 2018年03月29日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class LittleFisherJdbcConnectionFactory implements ConnectionFactory {

    private String userId;
    private String password;
    private String connectionURL;
    private String driverClass;
    private Properties otherProperties;

    /** 密码解密工具 */
    private static final String PASSWORD_RESOLVER_CLASS_PATH = "passwordResolver";

    /**
     * This constructor is called when there is a JDBCConnectionConfiguration specified in the configuration.
     *
     * @param config the configuration
     */
    public LittleFisherJdbcConnectionFactory(JDBCConnectionConfiguration config) {
        super();
        userId = config.getUserId();
        password = config.getPassword();
        connectionURL = config.getConnectionURL();
        driverClass = config.getDriverClass();
        otherProperties = config.getProperties();
    }

    /**
     * This constructor is called when this connection factory is specified as the type in a ConnectionFactory
     * configuration element.
     */
    public LittleFisherJdbcConnectionFactory() {
        super();
    }

    @Override
    public Connection getConnection() throws SQLException {

        Properties props = new Properties();

        if (stringHasValue(userId)) {
            props.setProperty("user", userId);
        }

        if (stringHasValue(password)) {
            if (stringHasValue(otherProperties.getProperty(PASSWORD_RESOLVER_CLASS_PATH))) {
                JdbcConnectionPasswordResolver passwordResolver = (JdbcConnectionPasswordResolver)ObjectFactory
                    .createInternalObject(otherProperties.getProperty(PASSWORD_RESOLVER_CLASS_PATH));
                props.setProperty("password", passwordResolver.decrypt(password));
            } else {
                props.setProperty("password", password);
            }
        }

        props.putAll(otherProperties);

        Driver driver = getDriver();
        Connection conn = driver.connect(connectionURL, props);

        if (conn == null) {
            throw new SQLException(getString("RuntimeError.7"));
        }

        return conn;
    }

    private Driver getDriver() {
        Driver driver;

        try {
            Class<?> clazz = ObjectFactory.externalClassForName(driverClass);
            driver = (Driver)clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(getString("RuntimeError.8"), e);
        }

        return driver;
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        // this should only be called when this connection factory is
        // specified in a ConnectionFactory configuration
        userId = properties.getProperty("userId");
        password = properties.getProperty("password");
        connectionURL = properties.getProperty("connectionURL");
        driverClass = properties.getProperty("driverClass");

        otherProperties = new Properties();
        otherProperties.putAll(properties);

        // remove all the properties that we have specific attributes for
        otherProperties.remove("userId");
        otherProperties.remove("password");
        otherProperties.remove("connectionURL");
        otherProperties.remove("driverClass");
    }
}
