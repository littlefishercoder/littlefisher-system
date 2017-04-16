package com.yc.room1000.core.activiti.impl;

import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import com.yc.room1000.core.activiti.IProcessTask;
import com.yc.room1000.core.utils.Room1000Logger;

/**
 * 
 * Description: 
 *  
 * Created on 2017年1月13日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class ProcessTaskImpl implements IProcessTask {
    
    /** logger */
    private static Room1000Logger logger = Room1000Logger.getLogger(ProcessTaskImpl.class);
    
    /** processEngine */
    private static ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    @Override
    public void dispatcherOrder(Long workOrderId) {
        logger.debug("workOrderId: " + workOrderId);
        TaskService taskService = processEngine.getTaskService();

        Task task = processEngine.getTaskService().createTaskQuery().processVariableValueEquals("workOrderId", workOrderId).singleResult();
        if (task != null) {
            taskService.complete(task.getId());
        }
    }

    @Override
    public Map<String, Object> getInstanceVariables(Long workOrderId) {
        Task task = processEngine.getTaskService()
            .createTaskQuery()
            .processVariableValueEquals("workOrderId", workOrderId)
            .singleResult();
        return processEngine.getRuntimeService().getVariables(task.getProcessInstanceId());
    }

    @Override
    public void putInstanceVariables(Long workOrderId, Map<String, Object> variables) {
        Task task = processEngine.getTaskService()
            .createTaskQuery()
            .processVariableValueEquals("workOrderId", workOrderId)
            .singleResult();
        processEngine.getRuntimeService().setVariables(task.getProcessInstanceId(), variables);
        
    }

    @Override
    public void putInstanceVariable(Long workOrderId, String variableName, Object variableValue) {
        Task task = processEngine.getTaskService()
            .createTaskQuery()
            .processVariableValueEquals("workOrderId", workOrderId)
            .singleResult();
        processEngine.getRuntimeService().setVariable(task.getProcessInstanceId(), variableName, variableValue);
        
    }

}
