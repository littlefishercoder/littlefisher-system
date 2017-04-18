package com.littlefisher.core.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

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
@Import(value = {
        PropertySourceConfig.class, DataSourceConfig.class,
        SqlSessionFactoryBeanConfig.class, MapperScannerConfigurerConfig.class, 
        SystemEngineConfig.class, AopConfig.class,
        TransactionManagerConfig.class })
@ComponentScan(basePackages = {"com.littlefisher.core.aop", 
        "com.littlefisher.core.interceptor.service",
        "com.littlefisher.**.service.impl",
        "com.yc.room1000.**.service.impl" })
public class RootConfig {

}
