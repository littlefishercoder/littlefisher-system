package com.littlefisher.core.spring.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.littlefisher.core.engine.SystemEngineFactoryBean;

/**
 * 
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
    
    /**
     * dataSource
     */
    @Autowired
    private DataSource dataSource;

    /**
     * transactionManager
     */
    @Autowired
    private DataSourceTransactionManager transactionManager;
    
    /**
     * sqlSessionFactory
     */
    @Autowired
    private SqlSessionFactoryBean sqlSessionFactory;
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @return SystemEngineFactoryBean
     * @throws Exception <br>
     */
    @Bean
    public SystemEngineFactoryBean systemEngineFactoryBean() throws Exception {
        SystemEngineFactoryBean systemEngineFactoryBean = new SystemEngineFactoryBean();
        systemEngineFactoryBean.setSystemEngineConfig(systemEngineConfig());
        return systemEngineFactoryBean;
    }

    /**
     * 
     * Description: com.littlefisher.core.engine.SystemEngineConfig
     * 
     * @author jinyanan
     *
     * @return SystemEngineConfig
     * @throws Exception <br>
     */
    @Bean(destroyMethod = "destory")
    public com.littlefisher.core.engine.SystemEngineConfig systemEngineConfig() throws Exception {
        com.littlefisher.core.engine.SystemEngineConfig systemEngineConfig = new com.littlefisher.core.engine.SystemEngineConfig();
        systemEngineConfig.setDataSource(dataSource);
        systemEngineConfig.setDatabaseType("mysql");
        systemEngineConfig.setTransactionManager(transactionManager);
        systemEngineConfig.setSqlSessionFactory(sqlSessionFactory.getObject());
        return systemEngineConfig;
    }
}
