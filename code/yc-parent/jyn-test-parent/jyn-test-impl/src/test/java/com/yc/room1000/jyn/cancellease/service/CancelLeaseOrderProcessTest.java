package com.yc.room1000.jyn.cancellease.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yc.room1000.core.activiti.IProcessDeploy;
import com.yc.room1000.core.activiti.IProcessStart;
import com.yc.room1000.core.activiti.IProcessTask;
import com.yc.room1000.core.activiti.ITaskServiceExecuter;
import com.yc.room1000.core.activiti.ITaskServiceMatcher;
import com.yc.room1000.core.activiti.impl.ProcessDeployImpl;
import com.yc.room1000.core.activiti.impl.ProcessStartImpl;
import com.yc.room1000.core.activiti.impl.ProcessTaskImpl;

/**
 * 
 * Description: 
 *  
 * Created on 2017年1月23日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-core.xml")
@Transactional
public class CancelLeaseOrderProcessTest {

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     */
    @Test
    public void testDeploy() {
        String processName = "CancelLeaseProcess";
        String classPath = "diagrams/cancellease";
        IProcessDeploy deploy = new ProcessDeployImpl();
        deploy.deployFlow(processName, classPath);
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     */
    @Test
    public void testStart() {
        String processInstanceKey = "CancelLeaseProcess";
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("channel", "2");
        IProcessStart start = new ProcessStartImpl();
        start.flowStart(processInstanceKey, variables);
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     */
    @Test
    public void testAssignOrder() {
        IProcessTask task = new ProcessTaskImpl();
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("ORDER_ID", "1");
        task.executeWork("assignOrder", variables, new TaskServiceMatcher(), new ITaskServiceExecuter() {
            
            @Override
            public Map<String, Object> execute(Map<String, Object> variables) {
                variables.put("needClose", "N");
                return variables;
            }
        });
        task.dispatcherOrder("assignOrder", variables, new TaskServiceMatcher());
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     */
    @Test
    public void testTakeOrder() {
        IProcessTask task = new ProcessTaskImpl();
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("ORDER_ID", "1");
        task.executeWork("takeOrder", variables, new TaskServiceMatcher(), new ITaskServiceExecuter() {

            @Override
            public Map<String, Object> execute(Map<String, Object> variables) {
                return variables;
            }
            
        });
        task.dispatcherOrder("takeOrder", variables, new TaskServiceMatcher());
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     */
    @Test
    public void testButlerGetHome() {
        IProcessTask task = new ProcessTaskImpl();
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("ORDER_ID", "1");
        task.executeWork("butlerGetHome", variables, new TaskServiceMatcher(), new ITaskServiceExecuter() {
            
            @Override
            public Map<String, Object> execute(Map<String, Object> variables) {
                return variables;
            }
        });
        task.dispatcherOrder("butlerGetHome", variables, new TaskServiceMatcher());
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     */
    @Test
    public void testRentalAccount() {
        IProcessTask task = new ProcessTaskImpl();
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("ORDER_ID", "1");
        task.executeWork("rentalAccount", variables, new TaskServiceMatcher(), new ITaskServiceExecuter() {
            
            @Override
            public Map<String, Object> execute(Map<String, Object> variables) {
                variables.put("needRegetHome", "N");
                return variables;
            }
        });
        task.dispatcherOrder("rentalAccount", variables, new TaskServiceMatcher());
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     */
    @Test
    public void testMarketingExecutiveAudit() {
        IProcessTask task = new ProcessTaskImpl();
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("ORDER_ID", "1");
        task.executeWork("marketingExecutiveAudit", variables, new TaskServiceMatcher(), new ITaskServiceExecuter() {
            
            @Override
            public Map<String, Object> execute(Map<String, Object> variables) {
                variables.put("needReadjust", "N");
                return variables;
            }
        });
        task.dispatcherOrder("marketingExecutiveAudit", variables, new TaskServiceMatcher());
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     */
    @Test
    public void testFinanceAudit() {
        IProcessTask task = new ProcessTaskImpl();
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("ORDER_ID", "1");
        task.executeWork("financeAudit", variables, new TaskServiceMatcher(), new ITaskServiceExecuter() {
            
            @Override
            public Map<String, Object> execute(Map<String, Object> variables) {
                variables.put("financeAuditNotPass", "N");
                return variables;
            }
        });
        task.dispatcherOrder("financeAudit", variables, new TaskServiceMatcher());
    }
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     */
    @Test
    public void testWait2Pay() {
        IProcessTask task = new ProcessTaskImpl();
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("ORDER_ID", "1");
        task.executeWork("wait2Pay", variables, new TaskServiceMatcher(), new ITaskServiceExecuter() {
            
            @Override
            public Map<String, Object> execute(Map<String, Object> variables) {
                return variables;
            }
        });
        task.dispatcherOrder("wait2Pay", variables, new TaskServiceMatcher());
    }
    
}

/**
 * 
 * Description: 
 *  
 * Created on 2017年1月23日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
class TaskServiceMatcher implements ITaskServiceMatcher {

    @Override
    public boolean matchTask(Map<String, Object> variables, Map<String, Object> processVariables) {
        if (variables.get("ORDER_ID").equals(processVariables.get("ORDER_ID"))) {
            return true;
        }
        return false;
    }
    
}
