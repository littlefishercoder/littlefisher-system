package com.littlefisher.spring.boot.autoconfigure;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Description: LittleFisherProperties.java
 *
 * Created on 2017年12月05日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ConfigurationProperties(prefix = "littlefisher")
public class LittleFisherProperties {

    /** mybatis相关配置 */
    private MybatisConfiguration mybatis = new MybatisConfiguration();

    /** shiro相关配置 */
    private ShiroConfiguration shiro = new ShiroConfiguration();

    public static class ShiroConfiguration {

        /** 是否开启shrio */
        private String enabled;

        /** 登录的页面路径 */
        private String loginUrl;

        /** 登录成功的页面路径 */
        private String successUrl;

        /** 未授权的页面路径 */
        private String unauthorizedUrl;

        /** Shiro鉴权拦截器 */
        private Map<String, String> filterChainDefinition = new HashMap<>();

        public String getEnabled() {
            return enabled;
        }

        public void setEnabled(String enabled) {
            this.enabled = enabled;
        }

        public String getSuccessUrl() {
            return successUrl;
        }

        public void setSuccessUrl(String successUrl) {
            this.successUrl = successUrl;
        }

        public String getUnauthorizedUrl() {
            return unauthorizedUrl;
        }

        public void setUnauthorizedUrl(String unauthorizedUrl) {
            this.unauthorizedUrl = unauthorizedUrl;
        }

        public String getLoginUrl() {
            return loginUrl;
        }

        public void setLoginUrl(String loginUrl) {
            this.loginUrl = loginUrl;
        }

        public Map<String, String> getFilterChainDefinition() {
            return filterChainDefinition;
        }

        public void setFilterChainDefinition(Map<String, String> filterChainDefinition) {
            this.filterChainDefinition = filterChainDefinition;
        }

        @Override
        public String toString() {
            return "ShiroConfiguration{" + "enabled='" + enabled + '\'' + ", loginUrl='" + loginUrl + '\''
                   + ", successUrl='" + successUrl + '\'' + ", unauthorizedUrl='" + unauthorizedUrl + '\''
                   + ", filterChainDefinition=" + filterChainDefinition + '}';
        }
    }

    /**
     * mybatis相关配置
     */
    public static class MybatisConfiguration {

        /** mybatis中枚举对应的路径 */
        private String typeEnumsPackage;

        public String getTypeEnumsPackage() {
            return typeEnumsPackage;
        }

        public void setTypeEnumsPackage(String typeEnumsPackage) {
            this.typeEnumsPackage = typeEnumsPackage;
        }

        @Override
        public String toString() {
            return "MybatisConfiguration{" + "typeEnumsPackage='" + typeEnumsPackage + '\'' + '}';
        }
    }

    public MybatisConfiguration getMybatis() {
        return mybatis;
    }

    public void setMybatis(MybatisConfiguration mybatis) {
        this.mybatis = mybatis;
    }

    public ShiroConfiguration getShiro() {
        return shiro;
    }

    public void setShiro(ShiroConfiguration shiro) {
        this.shiro = shiro;
    }

    @Override
    public String toString() {
        return "LittleFisherProperties{" + "mybatis=" + mybatis + ", shiro=" + shiro + '}';
    }
}
