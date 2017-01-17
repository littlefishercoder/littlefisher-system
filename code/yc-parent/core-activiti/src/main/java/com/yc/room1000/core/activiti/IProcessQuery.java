package com.yc.room1000.core.activiti;

import java.util.List;

import org.activiti.engine.history.HistoricActivityInstance;

/**
 * 
 * Description: 
 *  
 * Created on 2017年1月17日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IProcessQuery {

    /**
     * 
     * Description: 根据实例id查询已完成的环节
     * 
     * @author jinyanan
     *
     * @param instanceId instanceId
     * @return List<HistoricActivityInstance>
     */
    List<HistoricActivityInstance> getFinishedActivityByInstanceId(Long instanceId);
    
    /**
     * 
     * Description: 根据实例id查询未完成的环节
     * 
     * @author jinyanan
     *
     * @param instanceId instanceId
     * @return List<HistoricActivityInstance>
     */
    List<HistoricActivityInstance> getUnfinishedActivityByInstanceId(Long instanceId);
}
