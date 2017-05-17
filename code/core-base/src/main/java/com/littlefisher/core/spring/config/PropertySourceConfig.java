package com.littlefisher.core.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

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
@PropertySources(value = {
        @PropertySource("file:${SYSTEM_HOME}/etc/properties/jdbc.properties")
        })
public class PropertySourceConfig {

    /**
     * 
     * Description: 配置资源文件
     * 
     * @author jinyanan
     *
     * @return PropertySourcesPlaceholderConfigurer
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
