package com.yc.activiti.service;

import java.util.Map;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import com.yc.core.utils.Room1000Logger;

/**
 * 
 * Description: 自动环节
 *  
 * Created on 2017年1月12日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class Auto2Service implements JavaDelegate {
    
    /** logger */
    private static Room1000Logger logger = Room1000Logger.getLogger(Auto2Service.class);

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Map<String, Object> variables = execution.getVariables();
        
//        System.out.println("------------AutoService-----------");
//        System.out.println("variables: " + variables);
        logger.debug("------------AutoService-----------");
        logger.debug("variables: " + variables);
        
    }

}
