package com.littlefisher.core.activiti;

import java.util.List;
import java.util.Map;

import com.littlefisher.core.activiti.model.ActivitiStepDto;

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
     * @param workOrderId workOrderId
     */
    void dispatcherOrder(Long workOrderId);
    
    /**
     * 
     * Description: 获取workOrderId对应流程的参数
     * 
     * @author jinyanan
     *
     * @param workOrderId workOrderId
     * @return Map<String, Object>
     */
    Map<String, Object> getInstanceVariables(Long workOrderId);
    
    /**
     * 
     * Description: 向workOrderId对应流程的参数替换为variables
     * 
     * @author jinyanan
     *
     * @param workOrderId workOrderId
     * @param variables variables
     */
    void putInstanceVariables(Long workOrderId, Map<String, Object> variables);
    
    /**
     * 
     * Description: 向workOrderId对应流程的参数新增<variableName,variableValue>
     * 
     * @author jinyanan
     *
     * @param workOrderId workOrderId
     * @param variableName variableName
     * @param variableValue variableValue
     */
    void putInstanceVariable(Long workOrderId, String variableName, Object variableValue);
    
    /**
     * 
     * Description: 直接结束流程
     * 
     * @author jinyanan
     *
     * @param workOrderId workOrderId
     * @throws Exception <br>
     */
    void endProcess(Long workOrderId) throws Exception;
    
    /**
     * 
     * Description: 直接到达activityId对应的节点
     * 
     * @author jinyanan
     *
     * @param workOrderId workOrderId
     * @param activityId activityId
     * @throws Exception <br>
     */
    void direct2Activity(Long workOrderId, String activityId) throws Exception;
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param workOrderId workOrderId
     * @return List<ActivitiStepDto>
     * @throws Exception <br>
     */
    List<ActivitiStepDto> getAllTaskActiviti(Long workOrderId) throws Exception;
}
