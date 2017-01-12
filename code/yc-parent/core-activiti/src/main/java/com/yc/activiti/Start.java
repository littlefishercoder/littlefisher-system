package com.yc.activiti;

import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import com.yc.core.utils.Room1000Logger;

/**
 * 
 * Description: 流程启动
 *  
 * Created on 2017年1月12日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class Start {

    /** logger */
    private static Room1000Logger logger = Room1000Logger.getLogger(Start.class);
        
    /** processEngine */
    private static ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    /**
     * 
     * Description: 启动流程<br> 
     *  
     * @author jin.yanan<br>
     * @taskId <br>
     * @param processInstanceKey 
     * @param variables 
     */
    public void flowStart(String processInstanceKey, Map<String, Object> variables)  {
        
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService
                .startProcessInstanceByKey(processInstanceKey, variables);
        logger.debug("Id：" + processInstance.getId());
        logger.debug("Name：" + processInstance.getName());
    }
}
