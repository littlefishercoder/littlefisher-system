package com.littlefisher.core.activiti;

import java.util.Map;

/**
 * 
 * Description: 分支判断需要实现的接口
 *  
 * Created on 2017年1月22日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IProcessExpression {
    
    /**
     * 
     * Description: 根据入参判断走哪条分支
     * 
     * @author jinyanan
     *
     * @param variables 入参
     * @return true-走当前分支；false-不走当前分支
     */
    boolean getResult(Map<String, Object> variables);

}
