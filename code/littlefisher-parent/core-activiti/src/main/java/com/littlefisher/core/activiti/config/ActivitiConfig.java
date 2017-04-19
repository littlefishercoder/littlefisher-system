package com.littlefisher.core.activiti.config;

import javax.sql.DataSource;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.bpmn.parser.factory.ActivityBehaviorFactory;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.littlefisher.core.activiti.ext.ActivityBehaviorFactoryExt;
import com.littlefisher.core.activiti.ext.ExclusiveGatewayActivityBehaviorExt;

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
    public StandaloneProcessEngineConfiguration standaloneProcessEngineConfiguration() {
        StandaloneProcessEngineConfiguration standaloneProcessEngineConfiguration = new StandaloneProcessEngineConfiguration();
        standaloneProcessEngineConfiguration.setDataSource(dataSource);
        standaloneProcessEngineConfiguration.setDatabaseType("mysql");
        standaloneProcessEngineConfiguration.setDatabaseSchemaUpdate("true");
        standaloneProcessEngineConfiguration.setJobExecutorActivate(false);
        standaloneProcessEngineConfiguration.setActivityBehaviorFactory(activityBehaviorFactory());
        return standaloneProcessEngineConfiguration;
    }
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @return ActivityBehaviorFactory
     */
    @Bean
    public ActivityBehaviorFactory activityBehaviorFactory() {
        ActivityBehaviorFactoryExt activityBehaviorFactory = new ActivityBehaviorFactoryExt();
        activityBehaviorFactory.setExclusiveGatewayActivityBehaviorExt(exclusiveGatewayActivityBehaviorExt());
        return activityBehaviorFactory;
    }
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @return ExclusiveGatewayActivityBehaviorExt
     */
    @Bean
    public ExclusiveGatewayActivityBehaviorExt exclusiveGatewayActivityBehaviorExt() {
        return new ExclusiveGatewayActivityBehaviorExt();
    }
    
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
