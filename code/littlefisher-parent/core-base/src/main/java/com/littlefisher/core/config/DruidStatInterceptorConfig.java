package com.littlefisher.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.spring.stat.BeanTypeAutoProxyCreator;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import com.littlefisher.core.interceptor.service.ServiceImpl;

/**
 * Description: Druid监控配置
 * {@link @link(https://github.com/alibaba/druid/wiki/%E9%85%8D%E7%BD%AE_Druid%E5%92%8CSpring%E5%85%B3%E8%81%94%E7%9B%91%E6%8E%A7%E9%85%8D%E7%BD%AE)}
 *
 * Created on 2017年5月11日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Configuration
public class DruidStatInterceptorConfig {

    /**
     * Description: 拦截器配置
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

    /**
     * Description: Druid提供了Spring和Jdbc的关联监控。
     *
     * @return DruidStatInterceptor
     */
    @Bean(name = "druid-stat-interceptor")
    public DruidStatInterceptor getDruidStatInterceptor() {
        return new DruidStatInterceptor();
    }

}
