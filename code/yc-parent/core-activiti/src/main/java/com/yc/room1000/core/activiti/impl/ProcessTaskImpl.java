package com.yc.room1000.core.activiti.impl;

import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import com.yc.room1000.core.activiti.IProcessTask;
import com.yc.room1000.core.activiti.ITaskServiceExecuter;
import com.yc.room1000.core.activiti.ITaskServiceMatcher;
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

    @Override
    public void executeWork(String linkName, Map<String, Object> variables, ITaskServiceMatcher matcher,
        ITaskServiceExecuter executer) {
        logger.debug("linkName: " + linkName);
        TaskService taskService = processEngine.getTaskService();
        List<Task> taskList = processEngine.getTaskService().createTaskQuery().taskAssignee(linkName).list();

        for (Task task : taskList) {
            if (matcher.matchTask(variables, taskService.getVariables(task.getId()))) {
                Map<String, Object> variablesBefore = taskService.getVariables(task.getId());
                logger.debug("before execute variables: " + variablesBefore);
                Map<String, Object> variablesAfter = executer.execute(taskService.getVariables(task.getId()));
                taskService.setVariables(task.getId(), variablesAfter);
                // taskService.getVariables(task.getId()).putAll(variablesAfter);
                logger.debug("after execute variables: " + variablesBefore);
            }
        }
    }

    @Override
    public Map<String, Object> getTaskVariables(String linkName, Map<String, Object> variables, ITaskServiceMatcher matcher) {
        TaskService taskService = processEngine.getTaskService();
        List<Task> taskList = processEngine.getTaskService()
            .createTaskQuery()
            .taskAssignee(linkName)
            .list();
        
        for (Task task : taskList) {
            if (matcher.matchTask(variables, taskService.getVariables(task.getId()))) {
                return taskService.getVariables(task.getId());
            }
        }
        return null;
    }

}
