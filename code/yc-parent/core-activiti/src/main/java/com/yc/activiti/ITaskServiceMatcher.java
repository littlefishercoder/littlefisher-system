package com.yc.activiti;

import java.util.Map;

/**
 * 
 * Description: 人工环节时，根据入参来匹配具体的流程实例
 *  
 * Created on 2017年1月13日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface ITaskServiceMatcher {

    /**
     * 
     * Description: 匹配Task时的条件（满足一定条件进行回单）
     * 
     * @author jinyanan
     *
     * @param variables 用户当前task输入的数据
     * @param taskVariables 流程中已存在的数据
     * @return <br>
     */
    boolean matchTask(Map<String, Object> variables, Map<String, Object> taskVariables);
}
