package com.littlefisher.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.littlefisher.core.config.kafka.KafkaConfig;

/**
 * Description:
 *
 * Created on 2017年4月18日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Configuration
@ComponentScan(basePackages = {
        "com.littlefisher.core.interceptor.service",
        "com.littlefisher.**.service.impl",
        "com.littlefisher.core.utils",
        "com.littlefisher.core.exception",
        })
@PropertySources({
        @PropertySource("file:${SYSTEM_HOME}/etc/properties/jdbc.properties"),
        @PropertySource("file:${SYSTEM_HOME}/etc/properties/kafka.properties")
})
@Import(value = {
        DataSourceConfig.class,
        SqlSessionFactoryBeanConfig.class,
        MapperScannerConfigurerConfig.class,
        SystemEngineConfig.class,
        TransactionManagerConfig.class,
        DruidConfig.class,
//        KafkaConfig.class,
        })
public class RootConfig {

}
