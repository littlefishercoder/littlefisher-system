package com.yc.room1000.core.activiti.impl;

import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricActivityInstance;

import com.yc.room1000.core.activiti.IProcessQuery;

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
public class ProcessQueryImpl implements IProcessQuery {
    
    /** processEngine */
    private static ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    @Override
    public List<HistoricActivityInstance> getFinishedActivityByInstanceId(String instanceId) {
        HistoryService historyService = processEngine.getHistoryService();
        List<HistoricActivityInstance> activityInstanceList = historyService.createHistoricActivityInstanceQuery()
            .processInstanceId(instanceId)
            .finished()
            .list();
        return activityInstanceList;
    }

    @Override
    public List<HistoricActivityInstance> getUnfinishedActivityByInstanceId(String instanceId) {
        HistoryService historyService = processEngine.getHistoryService();
        List<HistoricActivityInstance> activityInstanceList = historyService.createHistoricActivityInstanceQuery()
            .processInstanceId(instanceId)
            .unfinished()
            .list();
        return activityInstanceList;
    }

}
