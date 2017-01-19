package com.yc.room1000.core.activiti;

import java.util.Map;

/**
 * 
 * Description: 
 *  
 * Created on 2017年1月19日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface ITaskServiceExecuter {

    /**
     * 
     * Description: 人工环节执行具体的业务逻辑，其中variables为流程中的参数
     * 
     * @author jinyanan
     *
     * @param variables 流程中的参数
     * @return Map<String, Object> 重新传入流程的参数
     */
    Map<String, Object> execute(Map<String, Object> variables);
}
