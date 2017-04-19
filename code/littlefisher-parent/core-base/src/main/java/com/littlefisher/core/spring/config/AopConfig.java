package com.littlefisher.core.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.littlefisher.core.spring.config.aop.LoggerAspect;

/**
 * 
 * Description: AopConfig
 *  
 * Created on 2017年4月18日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

    /**
     * 
     * Description: 日志打印切面
     * 
     * @author jinyanan
     *
     * @return LoggerAspect
     */
    @Bean
    public LoggerAspect loggerAspect() {
        return new LoggerAspect();
    }
}
