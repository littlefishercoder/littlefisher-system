package com.littlefisher.core.activiti.impl;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;

import com.littlefisher.core.activiti.IProcessDeploy;
import com.littlefisher.core.enums.EnumSymbol;
import com.littlefisher.core.utils.LittleFisherLogger;
import com.littlefisher.core.utils.StringUtil;

/**
 * 
 * Description: 流程发布
 *  
 * Created on 2017年1月12日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class ProcessDeployImpl implements IProcessDeploy {
    
    /** logger */
    private static LittleFisherLogger logger = LittleFisherLogger.getLogger(ProcessDeployImpl.class);
    
    /** processEngine */
    private static ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    /** BPMN_FINAL_NAME */
    private static final String BPMN_FINAL_NAME = ".bpmn";

    /** PNG_FINAL_NAME */
    private static final String PNG_FINAL_NAME = ".png";

    @Override
    public void deployFlow(String processName, String classPath) {
        if (StringUtil.isNotEmpty(classPath) && !classPath.endsWith(EnumSymbol.BACKSLASH.getCode())) {
            classPath += EnumSymbol.BACKSLASH.getCode();
        }
        Deployment deployment = processEngine.getRepositoryService()
                            .createDeployment()
                            .name(processName)
                            .addClasspathResource(classPath + processName + BPMN_FINAL_NAME)
                            .addClasspathResource(classPath + processName + PNG_FINAL_NAME)
                            .deploy();
        logger.debug("Id：" + deployment.getId());
        logger.debug("Name：" + deployment.getName());
    }
    
    @Override
    public void deployFlow(String processName) {
        deployFlow(processName, null);
    }

}
