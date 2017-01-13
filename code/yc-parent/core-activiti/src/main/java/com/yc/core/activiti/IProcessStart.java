package com.yc.core.activiti;

import java.util.Map;

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
public interface IProcessStart {
    
    /**
     * 
     * Description: 启动流程<br> 
     *  
     * @author jin.yanan<br>
     * @taskId <br>
     * @param processInstanceKey 流程名
     * @param variables 流程启动时所需的参数
     */
    void flowStart(String processInstanceKey, Map<String, Object> variables);
    
    /**
     * 
     * Description: 启动流程
     * 
     * @author jinyanan
     *
     * @param processInstanceKey 流程名
     */
    void flowStart(String processInstanceKey);
}
