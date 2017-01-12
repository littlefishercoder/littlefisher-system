package com.yc.activiti.service;

import java.util.Map;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import com.yc.core.utils.Room1000Logger;

/**
 * 
 * Description: BeforeArtificialService
 *  
 * Created on 2017年1月12日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class BeforeArtificialService implements TaskListener {

    /**
     * serialVersionUID 
     */
    private static final long serialVersionUID = 4975455851132934217L;
    
    /** logger */
    private static Room1000Logger logger = Room1000Logger.getLogger(BeforeArtificialService.class);

    @Override
    public void notify(DelegateTask delegateTask) {
        Map<String, Object> variables = delegateTask.getVariables();
//        System.out.println("------------BeforeArtificialService-----------");
//        System.out.println("variables: " + variables);
        
        logger.debug("------------AutoService-----------");
        logger.debug("variables: " + variables);
    }

}
