package com.littlefisher.core.activiti.impl;

import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import com.littlefisher.core.activiti.IProcessStart;
import com.littlefisher.core.utils.LittleFisherLogger;

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
public class ProcessStartImpl implements IProcessStart {

    /** logger */
    private static LittleFisherLogger logger = LittleFisherLogger.getLogger(ProcessStartImpl.class);
        
    /** processEngine */
    private static ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    @Override
    public void flowStart(String processInstanceKey, Map<String, Object> variables)  {
        
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService
                .startProcessInstanceByKey(processInstanceKey, variables);
        logger.debug("processInstanceId：" + processInstance.getId());
        logger.debug("Name：" + processInstance.getName());
    }
    
    @Override
    public void flowStart(String processInstanceKey) {
        this.flowStart(processInstanceKey, null);
    }
}
