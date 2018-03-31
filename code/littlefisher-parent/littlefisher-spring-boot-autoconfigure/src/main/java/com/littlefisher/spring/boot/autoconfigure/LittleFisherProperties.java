package com.littlefisher.spring.boot.autoconfigure;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.littlefisher.spring.boot.stereotype.enums.EnumRegistryType;

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

    /** dubbo相关配置 */
    private DubboConfiguration dubbo = new DubboConfiguration();

    /** dubbo相关配置 */
    public static class DubboConfiguration {

        /** 应用名 */
        private String appName;

        /** 超时时间 */
        private Duration timeout;

        /** 注册中心类型 */
        private EnumRegistryType registryType;

        /** 这次中心ip地址 */
        private String ips;

        /**
         * 消费方相关配置
         */
        public static class Consumer {

            /** 重试次数 */
            private Integer retries;

            public Integer getRetries() {
                return retries;
            }

            public void setRetries(Integer retries) {
                this.retries = retries;
            }

            @Override
            public String toString() {
                return "Consumer{" + "retries=" + retries + '}';
            }
        }

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }

        public Duration getTimeout() {
            return timeout;
        }

        public void setTimeout(Duration timeout) {
            this.timeout = timeout;
        }

        public EnumRegistryType getRegistryType() {
            return registryType;
        }

        public void setRegistryType(EnumRegistryType registryType) {
            this.registryType = registryType;
        }

        public String getIps() {
            return ips;
        }

        public void setIps(String ips) {
            this.ips = ips;
        }

        @Override
        public String toString() {
            return "DubboConfiguration{" + "appName='" + appName + '\'' + ", timeout=" + timeout + ", registryType="
                + registryType + ", ips='" + ips + '\'' + '}';
        }
    }

    /** shiro相关配置 */
    public static class ShiroConfiguration {

        /** 是否开启shrio */
        private String enabled;

        /** 登录的页面路径 */
        private String loginUrl;

        /** 登录成功的页面路径 */
        private String successUrl;

        /** 未授权的页面路径 */
        private String unauthorizedUrl;

        /** 是否针对于Swagger做拦截校验 */
        private String swaggerFileChainEnable;

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

        public String getSwaggerFileChainEnable() {
            return swaggerFileChainEnable;
        }

        public void setSwaggerFileChainEnable(String swaggerFileChainEnable) {
            this.swaggerFileChainEnable = swaggerFileChainEnable;
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
                + ", swaggerFileChainEnable='" + swaggerFileChainEnable + '\'' + ", filterChainDefinition="
                + filterChainDefinition + '}';
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

    public DubboConfiguration getDubbo() {
        return dubbo;
    }

    public void setDubbo(DubboConfiguration dubbo) {
        this.dubbo = dubbo;
    }

    @Override
    public String toString() {
        return "LittleFisherProperties{" + "mybatis=" + mybatis + ", shiro=" + shiro + ", dubbo=" + dubbo + '}';
    }
}
