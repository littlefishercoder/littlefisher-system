package com.yc.room1000.jyn.cancellease.service.impl;

import java.util.Map;

import com.yc.room1000.core.activiti.IProcessExpression;

/**
 * 
 * Description: 
 *  
 * Created on 2017年1月22日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class CheckNeedCloseServiceImpl implements IProcessExpression {

    @Override
    public boolean getResult(Map<String, Object> variables) {
        return true;
    }

}
