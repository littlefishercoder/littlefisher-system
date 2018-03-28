package com.littlefisher.core.biz.framework.config.shiro;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 *
 * @author jinyn22648
 * @version $$Id: ShiroPostProcessorConfig.java, v 0.1 2017/12/20 下午6:12 jinyn22648 Exp $$
 */
@Configuration
public class ShiroPostProcessorConfig {

    /**
     * Shiro生命周期处理器
     * @return
     * 保证实现了Shiro内部lifecycle函数的bean执行
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @DependsOn({ "lifecycleBeanPostProcessor" })
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }
}
