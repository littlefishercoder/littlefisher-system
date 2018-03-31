package com.littlefisher.user.config.shiro;

import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Maps;
import com.littlefisher.spring.boot.autoconfigure.LittleFisherProperties;

/**
 * Description: ShiroConfig.java
 *
 * Created on 2017年12月08日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Configuration
@EnableConfigurationProperties(LittleFisherProperties.class)
@ConditionalOnProperty(prefix = "littlefisher.shiro", value = "enabled", havingValue = "true")
public class ShiroConfig {

    @Autowired
    private LittleFisherProperties littleFisherProperties;

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 过滤链定义，从上向下顺序执行，一般将/**放在最为下边
        // 这是一个坑呢，一不小心代码就不好使了
        Map<String, String> filterChainDefinitionMap = Maps.newLinkedHashMap();

        if (Boolean.valueOf(littleFisherProperties.getShiro().getSwaggerFileChainEnable())) {
            filterChainDefinitionMap.putAll(getSwaggerFilterChainDefinitionMap());
        }

        // 添加application.yml中的过滤链
        filterChainDefinitionMap.putAll(littleFisherProperties.getShiro().getFilterChainDefinition());

        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl(littleFisherProperties.getShiro().getLoginUrl());
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl(littleFisherProperties.getShiro().getSuccessUrl());

        // 未授权界面
        shiroFilterFactoryBean.setUnauthorizedUrl(littleFisherProperties.getShiro().getUnauthorizedUrl());
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 配置Swagger相关拦截
     * @return 过滤链
     */
    private Map<String, String> getSwaggerFilterChainDefinitionMap() {
        Map<String, String> filterChainDefinitionMap = Maps.newLinkedHashMap();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/swagger-ui.html", "anon");
        filterChainDefinitionMap.put("/META-INF/resources/**", "anon");
        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/v2/api-docs/**", "anon");
        filterChainDefinitionMap.put("/swagger-resources/**", "anon");
        return filterChainDefinitionMap;
    }

    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }

}
