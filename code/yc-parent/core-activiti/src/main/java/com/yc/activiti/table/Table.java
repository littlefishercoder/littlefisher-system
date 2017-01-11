package com.yc.activiti.table;

import org.activiti.engine.ProcessEngine;
import org.springframework.beans.factory.annotation.Autowired;

import com.yc.core.utils.Room1000Logger;

/**
 * 
 * Description: activiti相关表创建
 *  
 * Created on 2017年1月11日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class Table {
    
    /** logger */
    private static Room1000Logger logger = Room1000Logger.getLogger(Table.class);
    
    @Autowired
    private ProcessEngine processEngine;
    
    /**
     * 
     * Description: 创建activiti相关表结构
     * 
     * @author jinyanan
     *
     */
    public void createTable() {
        processEngine.getProcessEngineConfiguration().buildProcessEngine();
        logger.debug("-------------processEngine:" + processEngine);
    }

}
