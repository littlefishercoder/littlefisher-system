package com.littlefisher.core.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.littlefisher.core.engine.SystemEngineFactoryBean;

/**
 * Description: SystemEngineConfigConfig
 *
 * Created on 2017年4月18日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Configuration
public class SystemEngineConfig {

    /** dataSource */
    @Autowired
    private DataSource dataSource;

    /** transactionManager */
    @Autowired
    private DataSourceTransactionManager transactionManager;

    /** sqlSessionFactory */
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    /**
     * Description: SystemEngineFactoryBean
     *
     * @return SystemEngineFactoryBean
     */
    @Bean
    public SystemEngineFactoryBean systemEngineFactoryBean() {
        SystemEngineFactoryBean systemEngineFactoryBean = new SystemEngineFactoryBean();
        systemEngineFactoryBean.setSystemEngineConfig(systemEngineConfig());
        return systemEngineFactoryBean;
    }

    /**
     * Description: com.littlefisher.core.engine.SystemEngineConfig
     *
     * @return SystemEngineConfig
     */
    private com.littlefisher.core.engine.SystemEngineConfig systemEngineConfig() {
        com.littlefisher.core.engine.SystemEngineConfig systemEngineConfig = new com.littlefisher.core.engine.SystemEngineConfig();
        systemEngineConfig.setDataSource(dataSource);
        systemEngineConfig.setTransactionManager(transactionManager);
        systemEngineConfig.setSqlSessionFactory(sqlSessionFactory);
        return systemEngineConfig;
    }
}
