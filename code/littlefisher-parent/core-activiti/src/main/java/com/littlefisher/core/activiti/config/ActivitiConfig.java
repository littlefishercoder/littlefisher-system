package com.littlefisher.core.activiti.config;

import javax.sql.DataSource;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * 
 * Description: activiti配置文件
 *  
 * Created on 2017年4月19日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Configuration
public class ActivitiConfig {
    
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
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @return ProcessEngineFactoryBean
     */
    @Bean
    public ProcessEngineFactoryBean processEngineFactoryBean() {
        ProcessEngineFactoryBean processEngineFactoryBean = new ProcessEngineFactoryBean();
        processEngineFactoryBean.setProcessEngineConfiguration(standaloneProcessEngineConfiguration());
        return processEngineFactoryBean;
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @return StandaloneProcessEngineConfiguration
     */
    @Bean
    public ProcessEngineConfigurationImpl standaloneProcessEngineConfiguration() {
        SpringProcessEngineConfiguration springProcessEngineConfiguration = new SpringProcessEngineConfiguration();
        // 设置数据源
        springProcessEngineConfiguration.setDataSource(dataSource);
        // 设置数据库类型
        springProcessEngineConfiguration.setDatabaseType("mysql");
        // 设置Activiti启动关闭所做操作
        // false(默认)：如果启动时数据库和配置不匹配，则抛异常
        // true：启动时检查数据库，如果不匹配，则创建
        // create-drop：启动时创建，关闭时删除数据库
        springProcessEngineConfiguration.setDatabaseSchemaUpdate("true");
        // 设置Job扫描功能关闭
        springProcessEngineConfiguration.setJobExecutorActivate(false);
        // 设置事务处理功能
        springProcessEngineConfiguration.setTransactionManager(transactionManager);
//        springProcessEngineConfiguration.setActivityBehaviorFactory(activityBehaviorFactory());
        return springProcessEngineConfiguration;
    }
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @return ActivityBehaviorFactory
     */
//    @Bean
//    public ActivityBehaviorFactory activityBehaviorFactory() {
//        // 重置部分Activiti行为
//        ActivityBehaviorFactoryExt activityBehaviorFactory = new ActivityBehaviorFactoryExt();
//        activityBehaviorFactory.setExclusiveGatewayActivityBehaviorExt(exclusiveGatewayActivityBehaviorExt());
//        return activityBehaviorFactory;
//    }
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @return ExclusiveGatewayActivityBehaviorExt
     */
//    @Bean
//    public ExclusiveGatewayActivityBehaviorExt exclusiveGatewayActivityBehaviorExt() {
//        // 重置分支Activiti行为，能够识别自定义行为
//        return new ExclusiveGatewayActivityBehaviorExt();
//    }
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @return RepositoryService
     */
    @Bean(name = "repositoryService")
    public RepositoryService repositoryService() {
        return processEngineFactoryBean().getProcessEngineConfiguration().getRepositoryService();
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @return RuntimeService
     */
    @Bean(name = "runtimeService")
    public RuntimeService runtimeService() {
        return processEngineFactoryBean().getProcessEngineConfiguration().getRuntimeService();
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @return TaskService
     */
    @Bean(name = "taskService")
    public TaskService taskService() {
        return processEngineFactoryBean().getProcessEngineConfiguration().getTaskService();
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @return HistoryService
     */
    @Bean(name = "historyService")
    public HistoryService historyService() {
        return processEngineFactoryBean().getProcessEngineConfiguration().getHistoryService();
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @return ManagementService
     */
    @Bean(name = "managementService")
    public ManagementService managementService() {
        return processEngineFactoryBean().getProcessEngineConfiguration().getManagementService();
    }
    
}
