package com.littlefisher.core.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * Description: 
 *  
 * Created on 2017年4月18日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Configuration
@ComponentScan(basePackages = {"com.littlefisher.core.aop", 
        "com.littlefisher.core.interceptor.service",
        "com.littlefisher.**.service.impl",
        "com.yc.room1000.**.service.impl", })
public class SpringComponentScanConfig {

}
