package com.littlefisher.core.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.transaction.PlatformTransactionManager;

import com.littlefisher.core.event.EventDispatcher;
import com.littlefisher.core.event.EventDispatcherImpl;
import com.littlefisher.core.event.EventListener;
import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.CommandConfig;
import com.littlefisher.core.interceptor.CommandContextFactory;
import com.littlefisher.core.interceptor.CommandContextInterceptor;
import com.littlefisher.core.interceptor.CommandExecutor;
import com.littlefisher.core.interceptor.CommandExecutorImpl;
import com.littlefisher.core.interceptor.CommandInterceptor;
import com.littlefisher.core.interceptor.CommandInvoker;
import com.littlefisher.core.interceptor.SpringTransactionInterceptor;
import com.littlefisher.core.interceptor.service.ServiceImpl;
import com.littlefisher.core.utils.LittleFisherLogger;
import com.littlefisher.core.utils.StringUtil;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月10日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class SystemEngineConfig {

    /**
     * logger
     */
    private static LittleFisherLogger logger = LittleFisherLogger.getLogger(SystemEngineConfig.class);
    
    /**
     * DB_SCHEMA_UPDATE_FALSE
     */
    public static final String DB_SCHEMA_UPDATE_FALSE = "false";
    
    /**
     * DB_SCHEMA_UPDATE_TRUE
     */
    public static final String DB_SCHEMA_UPDATE_TRUE = "true";
    
    /**
     * dataSource
     */
    protected DataSource dataSource;
    
    /**
     * transactionManager
     */
    protected PlatformTransactionManager transactionManager;

    /**
     * sqlSessionFactory
     */
    protected SqlSessionFactory sqlSessionFactory;

    /**
     * dbSqlSessionFactory
     */
    protected DbSqlSessionFactory dbSqlSessionFactory;

    /**
     * commandContextFactory
     */
    protected CommandContextFactory commandContextFactory;

    /**
     * sessionFactories
     */
    protected Map<Class<?>, SessionFactory> sessionFactories;

    /**
     * enableEventDispatcher
     */
    protected boolean enableEventDispatcher = true;

    /**
     * eventDispatcher
     */
    protected EventDispatcher eventDispatcher;

    /**
     * eventListeners
     */
    protected List<EventListener> eventListeners;

    /**
     * typedEventListeners
     */
    protected Map<String, List<EventListener>> typedEventListeners;

    /**
     * services
     */
    protected Map<String, ServiceImpl> services = new HashMap<String, ServiceImpl>();

    /**
     * systemEngineName
     */
    protected String systemEngineName = "systemEngine";

    /**
     * commandInvoker
     */
    protected CommandInterceptor commandInvoker;

    /**
     * customPreCommandInterceptors
     */
    protected List<CommandInterceptor> customPreCommandInterceptors;

    /**
     * customPostCommandInterceptors
     */
    protected List<CommandInterceptor> customPostCommandInterceptors;

    /**
     * commandInterceptors
     */
    protected List<CommandInterceptor> commandInterceptors;

    /**
     * commandExecutor
     */
    protected CommandExecutor commandExecutor;

    /**
     * defaultCommandConfig
     */
    protected CommandConfig defaultCommandConfig;
    
    /**
     * databaseType
     */
    protected String databaseType;
    
    public String getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }

    /**
     * Description: <br>
     * 
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return <br>
     */
    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    /**
     * Description: <br>
     * 
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param sqlSessionFactory <br>
     */
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * Description: <br>
     * 
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return <br>
     */
    public String getSystemEngineName() {
        return systemEngineName;
    }

    /**
     * Description: <br>
     * 
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param systemEngineName <br>
     */
    public void setSystemEngineName(String systemEngineName) {
        this.systemEngineName = systemEngineName;
    }

    /**
     * Description: <br>
     * 
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return <br>
     */
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * Description: <br>
     * 
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param dataSource <br>
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Description: <br>
     * 
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return <br>
     */
    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }

    /**
     * Description: <br>
     * 
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param transactionManager <br>
     */
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return systemEngine
     * @throws BaseAppException <br>
     */
    public SystemEngine buildSystemEngine() throws BaseAppException {
        init();
        SystemEngine systemEngine = new SystemEngineImpl(this);
        return systemEngine;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @throws BaseAppException <br>
     */
    protected void init() throws BaseAppException {
        initDefaultCommandConfig();

        initCommandContextFactory();
        initDbSqlSessionFactory();
        initSessionFactories();

        initCommandInvoker();
        initCommandInterceptors();
        initCommandExecutor();

        initEventDispatcher();

    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param registerServices <br>
     */
    public void initServices(Map<String, ServiceImpl> registerServices) {
        if (registerServices != null) {
            for (Entry<String, ServiceImpl> entry : registerServices.entrySet()) {
                ServiceImpl serv = entry.getValue();
                initService(serv);
                services.put(entry.getKey(), serv);
            }
        }

    }
    
    /**
     * initService
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param serviceName <br>
     * @param registerService <br>
     */
    public void initService(String serviceName, ServiceImpl registerService) {
        if (registerService != null && StringUtil.isNotEmpty(serviceName)) {
            initService(registerService);
            services.put(serviceName, registerService);
        }

    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param service <br>
     */
    protected void initService(Object service) {
        if (service instanceof ServiceImpl) {
            ((ServiceImpl) service).setCommandExecutor(commandExecutor);
        }
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br> <br>
     */
    protected void initDefaultCommandConfig() {
        if (defaultCommandConfig == null) {
            defaultCommandConfig = new CommandConfig();
        }
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br> <br>
     */
    protected void initDbSqlSessionFactory() {
        if (dbSqlSessionFactory == null) {
            dbSqlSessionFactory = new DbSqlSessionFactory(sqlSessionFactory);
        }

    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br> <br>
     */
    protected void initSessionFactories() {
        if (sessionFactories == null) {
            sessionFactories = new HashMap<Class<?>, SessionFactory>();
            addSessionFactory(dbSqlSessionFactory);
        }
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param sessionFactory <br>
     */
    protected void addSessionFactory(SessionFactory sessionFactory) {
        sessionFactories.put(sessionFactory.getSessionType(), sessionFactory);
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br> <br>
     */
    protected void initCommandContextFactory() {
        if (commandContextFactory == null) {
            commandContextFactory = new CommandContextFactory();
            commandContextFactory.setSystemEngineConfig(this);
        }
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br> <br>
     */
    protected void initCommandInvoker() {
        if (commandInvoker == null) {
            commandInvoker = new CommandInvoker();
        }
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @throws BaseAppException <br>
     */
    protected void initCommandInterceptors() throws BaseAppException {
        if (commandInterceptors == null) {
            commandInterceptors = new ArrayList<CommandInterceptor>();
            if (customPreCommandInterceptors != null) {
                commandInterceptors.addAll(customPreCommandInterceptors);
            }
            commandInterceptors.addAll(getDefaultCommandInterceptors());
            if (customPostCommandInterceptors != null) {
                commandInterceptors.addAll(customPostCommandInterceptors);
            }
            commandInterceptors.add(commandInvoker);
        }
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @throws BaseAppException 
     * @taskId <br> <br>
     */
    private void initEventDispatcher() throws BaseAppException {
        if (this.eventDispatcher == null) {
            this.eventDispatcher = new EventDispatcherImpl();
        }

        this.eventDispatcher.setEnabled(enableEventDispatcher);

        if (eventListeners != null) {
            for (EventListener listenerToAdd : eventListeners) {
                this.eventDispatcher.addEventListener(listenerToAdd);
            }
        }

        if (typedEventListeners != null) {
            for (Entry<String, List<EventListener>> listenersToAdd : typedEventListeners.entrySet()) {
                // Extract types from the given string
                String[] types = getEventTypeListFromString(listenersToAdd.getKey());

                for (EventListener listenerToAdd : listenersToAdd.getValue()) {
                    this.eventDispatcher.addEventListener(listenerToAdd, types);
                }
            }
        }
    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param types <br>
     * @return <br>
     */
    private String[] getEventTypeListFromString(String types) {
        String[] emptyArray = new String[] {};
        if (types == null || types.isEmpty()) {
            return emptyArray;
        }
        String[] split = StringUtils.split(types, ",");
        return split;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return interceptors
     * @throws BaseAppException <br>
     */
    protected Collection<? extends CommandInterceptor> getDefaultCommandInterceptors() throws BaseAppException {
        List<CommandInterceptor> interceptors = new ArrayList<CommandInterceptor>();
        interceptors.add(new CommandContextInterceptor(commandContextFactory, this));

//        interceptors.add(new LogInterceptor());

        CommandInterceptor transactionInterceptor = createTransactionInterceptor();
        if (transactionInterceptor != null) {
            interceptors.add(transactionInterceptor);
        }

        return interceptors;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return SpringTransactionInterceptor
     * @throws BaseAppException <br>
     */
    protected CommandInterceptor createTransactionInterceptor() throws BaseAppException {
        if (transactionManager == null) {
            //transactionManager is required property for SpringProcessEngineConfiguration
            throw new BaseAppException("S-SYSTEMCOM-001");
        }

        return new SpringTransactionInterceptor(transactionManager);
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @throws BaseAppException <br>
     */
    protected void initCommandExecutor() throws BaseAppException {
        if (commandExecutor == null) {
            CommandInterceptor first = initInterceptorChain(commandInterceptors);
            commandExecutor = new CommandExecutorImpl(getDefaultCommandConfig(), first);
        }
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return <br>
     */
    public CommandInterceptor getCommandInvoker() {
        return commandInvoker;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param commandInvoker <br>
     */
    public void setCommandInvoker(CommandInterceptor commandInvoker) {
        this.commandInvoker = commandInvoker;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return <br>
     */
    public List<CommandInterceptor> getCustomPreCommandInterceptors() {
        return customPreCommandInterceptors;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param customPreCommandInterceptors <br>
     */
    public void setCustomPreCommandInterceptors(List<CommandInterceptor> customPreCommandInterceptors) {
        this.customPreCommandInterceptors = customPreCommandInterceptors;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return <br>
     */
    public List<CommandInterceptor> getCustomPostCommandInterceptors() {
        return customPostCommandInterceptors;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param customPostCommandInterceptors <br>
     */
    public void setCustomPostCommandInterceptors(List<CommandInterceptor> customPostCommandInterceptors) {
        this.customPostCommandInterceptors = customPostCommandInterceptors;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return <br>
     */
    public List<CommandInterceptor> getCommandInterceptors() {
        return commandInterceptors;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param commandInterceptors <br>
     */
    public void setCommandInterceptors(List<CommandInterceptor> commandInterceptors) {
        this.commandInterceptors = commandInterceptors;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return <br>
     */
    public CommandExecutor getCommandExecutor() {
        return commandExecutor;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param commandExecutor <br>
     */
    public void setCommandExecutor(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return <br>
     */
    public CommandConfig getDefaultCommandConfig() {
        return defaultCommandConfig;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param defaultCommandConfig <br>
     */
    public void setDefaultCommandConfig(CommandConfig defaultCommandConfig) {
        this.defaultCommandConfig = defaultCommandConfig;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param chain 
     * @return CommandInterceptor
     * @throws BaseAppException <br>
     */
    protected CommandInterceptor initInterceptorChain(List<CommandInterceptor> chain) throws BaseAppException {
        if (chain == null || chain.isEmpty()) {
            logger.error("invalid command interceptor chain configuration: " + chain);
            throw new BaseAppException("S-SYSTEMCOM-002");
        }
        for (int i = 0; i < chain.size() - 1; i++) {
            chain.get(i).setNext(chain.get(i + 1));
        }
        return chain.get(0);
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return <br>
     */
    public Map<Class<?>, SessionFactory> getSessionFactories() {
        return sessionFactories;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param sessionFactories 
     * @return <br>
     */
    public SystemEngineConfig setSessionFactories(Map<Class<?>, SessionFactory> sessionFactories) {
        this.sessionFactories = sessionFactories;
        return this;
    }

    public EventDispatcher getEventDispatcher() {
        return eventDispatcher;
    }

    public void setEventDispatcher(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    public void setEnableEventDispatcher(boolean enableEventDispatcher) {
        this.enableEventDispatcher = enableEventDispatcher;
    }

    public void setTypedEventListeners(Map<String, List<EventListener>> typedListeners) {
        this.typedEventListeners = typedListeners;
    }

    public void setEventListeners(List<EventListener> eventListeners) {
        this.eventListeners = eventListeners;
    }

    public boolean isEnableEventDispatcher() {
        return enableEventDispatcher;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param serviceName 
     * @return <br>
     */
    public ServiceImpl getService(String serviceName) {
        ServiceImpl serv = services.get(serviceName);
        return serv;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param serviceName <br>
     * @param service <br>
     */
    public void putService(String serviceName, ServiceImpl service) {
        ServiceImpl serv = services.get(serviceName);
        if (serv == null) {
            services.put(serviceName, service);
        }
    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br> <br>
     */
    public void destory() {
        // TODO Auto-generated catch block
//        logger.debug("do systemEngineConfig destory");
//        try {
//            ZcacheClient.getInstance().destory();
//        }
//        catch (BaseAppException e) {
//            // TODO Auto-generated catch block
//            logger.error("systemEngineConfig destory error", e);
//        }
        
    }
}
