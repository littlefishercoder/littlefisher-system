package com.littlefisher.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.spring.stat.BeanTypeAutoProxyCreator;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import com.littlefisher.core.interceptor.service.ServiceImpl;

/**
 * 
 * Description: Druid监控配置
 *  
 * Created on 2017年5月11日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Configuration
public class DruidConfig {
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @return DruidStatInterceptor
     */
    @Bean(name = "druid-stat-interceptor")
    public DruidStatInterceptor getDruidStatInterceptor() {
        return new DruidStatInterceptor();
    }
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @return BeanTypeAutoProxyCreator
     */
    @Bean(name = "druid-type-proxyCreator")
    public BeanTypeAutoProxyCreator getBeanTypeAutoProxyCreator() {
        BeanTypeAutoProxyCreator beanTypeAutoProxyCreator = new BeanTypeAutoProxyCreator();
        beanTypeAutoProxyCreator.setTargetBeanType(ServiceImpl.class);
        beanTypeAutoProxyCreator.setInterceptorNames("druid-stat-interceptor");
        return beanTypeAutoProxyCreator;
    }

}
