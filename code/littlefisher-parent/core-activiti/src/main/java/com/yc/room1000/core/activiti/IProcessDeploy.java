package com.yc.room1000.core.activiti;

/**
 * 
 * Description: 流程编译接口
 *  
 * Created on 2017年1月13日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IProcessDeploy {
    
    /**
     * 
     * Description:  流程发布
     * 
     * @author jinyanan
     *
     * @param processName 流程名字
     * @param classPath 流程文件所在目录
     */
    void deployFlow(String processName, String classPath);
    
    /**
     * 
     * Description: 流程发布
     * 
     * @author jinyanan
     *
     * @param processName 流程名字
     */
    void deployFlow(String processName);
}
