package com.yc.activiti.impl;

import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import com.yc.activiti.IProcessDispatcher;
import com.yc.activiti.ITaskServiceMatcher;
import com.yc.core.utils.Room1000Logger;

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
public class ProcessDispatcherImpl implements IProcessDispatcher {
    
    /** logger */
    private static Room1000Logger logger = Room1000Logger.getLogger(ProcessDispatcherImpl.class);
    
    /** processEngine */
    private static ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    @Override
    public void dispatcherOrder(String linkName, Map<String, Object> variables, ITaskServiceMatcher matcher) {
        logger.debug("linkName: " + linkName);
        TaskService taskService = processEngine.getTaskService();
        List<Task> taskList = processEngine.getTaskService()
            .createTaskQuery()
            .taskAssignee(linkName)
            .list();
        
        for (Task task : taskList) {
            if (matcher.matchTask(variables, taskService.getVariables(task.getId()))) {
                taskService.complete(task.getId());
            }
        }
    }

}
