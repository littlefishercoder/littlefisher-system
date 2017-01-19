package com.yc.room1000.core.activiti;

import java.util.Map;

/**
 * 
 * Description: 人工环节的回单操作
 *  
 * Created on 2017年1月13日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IProcessTask {

    /**
     * 
     * Description: 人工环节回单操作
     * 
     * @author jinyanan
     *
     * @param linkName 当前人工环节的assignee
     * @param variables 用来匹配流程实例的参数列表
     * @param matcher 人工环节的匹配器
     */
    void dispatcherOrder(String linkName, Map<String, Object> variables, ITaskServiceMatcher matcher);
    
    /**
     * 
     * Description: 人工环节执行逻辑
     * 
     * @author jinyanan
     *
     * @param linkName 当前人工环节的assignee
     * @param variables 用来匹配流程实例的参数列表
     * @param matcher 人工环节的匹配器
     * @param executer 人工环节的执行器
     */
    void executeWork(String linkName, Map<String, Object> variables, ITaskServiceMatcher matcher, ITaskServiceExecuter executer);
}
