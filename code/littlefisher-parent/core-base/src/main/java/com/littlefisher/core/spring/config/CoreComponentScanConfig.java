package com.littlefisher.core.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;

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
@ComponentScan(basePackages = {"com.littlefisher.core.utils",
        "com.littlefisher.core.exception" }, 
    includeFilters = {@Filter(ControllerAdvice.class) })
public class CoreComponentScanConfig {

}
