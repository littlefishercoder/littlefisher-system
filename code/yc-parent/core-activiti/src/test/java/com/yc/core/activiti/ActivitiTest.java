package com.yc.core.activiti;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yc.core.activiti.impl.ProcessDeployImpl;
import com.yc.core.activiti.impl.ProcessStartImpl;

/**
 * 
 * Description: 
 *  
 * Created on 2017年1月12日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:activiti.cfg.xml")
@Rollback
@Transactional
public class ActivitiTest {
    
    /**
     * 
     * Description: 测试流程发布
     * 
     * @author jinyanan
     *
     */
    @Test
    public void testDeploy() {
        String processName = "HelloWorldProcess";
        String classPath = "diagrams/helloworld";
        new ProcessDeployImpl().deployFlow(processName, classPath);
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
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("variable1", "1111111111");
        variables.put("variable2", "2222222222");
        variables.put("variable3", "3333333333");
        new ProcessStartImpl().flowStart(processInstanceKey, variables);
    }
}
