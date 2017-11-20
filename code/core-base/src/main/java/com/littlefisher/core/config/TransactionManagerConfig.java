package com.littlefisher.core.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * 
 * Description: 
 *  
 * Created on 2017年4月18日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Configuration
public class TransactionManagerConfig {
    
    /**
     * dataSource
     */
    @Autowired
    private DataSource dataSource;
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @return DataSourceTransactionManager
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

}
