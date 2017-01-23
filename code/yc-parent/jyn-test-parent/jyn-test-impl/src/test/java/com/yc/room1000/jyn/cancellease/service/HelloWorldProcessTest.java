package com.yc.room1000.jyn.cancellease.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yc.room1000.core.activiti.IProcessDeploy;
import com.yc.room1000.core.activiti.IProcessStart;
import com.yc.room1000.core.activiti.impl.ProcessDeployImpl;
import com.yc.room1000.core.activiti.impl.ProcessStartImpl;

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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/spring-core.xml")
@Rollback
@Transactional
public class HelloWorldProcessTest {

    /**
     * 
     * Description: 测试流程编译
     * 
     * @author jinyanan
     *
     */
    @Test
    public void testDeploy() {
        String processName = "HelloWorldProcess";
        String classPath = "diagrams/helloworld";
        IProcessDeploy deploy = new ProcessDeployImpl();
        deploy.deployFlow(processName, classPath);
    }
    
    /**
     * 
     * Description: 测试流程启动
     * 
     * @author jinyanan
     *
     */
    @Test
    public void testStart() {
        String processInstanceKey = "HelloWorldProcess";
        IProcessStart start = new ProcessStartImpl();
        start.flowStart(processInstanceKey);
    }
}
