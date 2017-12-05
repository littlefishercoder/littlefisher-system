package com.littlefisher.spring.boot.autoconfigure;

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

    @Override
    public String toString() {
        return "LittleFisherProperties{" + "mybatis=" + mybatis + '}';
    }
}
