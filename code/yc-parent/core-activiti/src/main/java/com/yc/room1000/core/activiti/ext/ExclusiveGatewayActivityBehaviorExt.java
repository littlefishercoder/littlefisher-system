package com.yc.room1000.core.activiti.ext;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.impl.Condition;
import org.activiti.engine.impl.bpmn.behavior.ExclusiveGatewayActivityBehavior;
import org.activiti.engine.impl.bpmn.helper.SkipExpressionUtil;
import org.activiti.engine.impl.bpmn.parser.BpmnParse;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;

import com.yc.room1000.core.activiti.IProcessExpression;
import com.yc.room1000.core.utils.Room1000Logger;
import com.yc.room1000.core.utils.StringUtil;

/**
 * Description: 重写分支判断环节 Created on 2017年1月22日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class ExclusiveGatewayActivityBehaviorExt extends ExclusiveGatewayActivityBehavior {

    /** logger */
    private static Room1000Logger logger = Room1000Logger.getLogger(ExclusiveGatewayActivityBehaviorExt.class);

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void leave(ActivityExecution execution) {

        logger.debug("Leaving activity '{}'", execution.getActivity().getId());

        PvmTransition outgoingSeqFlow = null;
        String defaultSequenceFlow = (String) execution.getActivity().getProperty("default");
        Iterator<PvmTransition> transitionIterator = execution.getActivity().getOutgoingTransitions().iterator();
        while (outgoingSeqFlow == null && transitionIterator.hasNext()) {
            PvmTransition seqFlow = transitionIterator.next();
            Expression skipExpression = seqFlow.getSkipExpression();

            if (!SkipExpressionUtil.isSkipExpressionEnabled(execution, skipExpression)) {
                Condition condition = (Condition) seqFlow.getProperty(BpmnParse.PROPERTYNAME_CONDITION);
                if (getInstanceResult(condition, execution.getVariables())) {
                    outgoingSeqFlow = seqFlow;
                } 
                else {
                    if ((condition == null && (defaultSequenceFlow == null || !defaultSequenceFlow.equals(seqFlow.getId())))
                        || (condition != null && condition.evaluate(seqFlow.getId(), execution))) {
                        logger.debug("Sequence flow '{}'selected as outgoing sequence flow.", seqFlow.getId());
                        outgoingSeqFlow = seqFlow;
                    }
                }
            }
            else if (SkipExpressionUtil.shouldSkipFlowElement(execution, skipExpression)) {
                outgoingSeqFlow = seqFlow;
            }
        }

        if (outgoingSeqFlow != null) {
            execution.take(outgoingSeqFlow);
        }
        else {

            if (defaultSequenceFlow != null) {
                PvmTransition defaultTransition = execution.getActivity().findOutgoingTransition(defaultSequenceFlow);
                if (defaultTransition != null) {
                    execution.take(defaultTransition);
                }
                else {
                    throw new ActivitiException("Default sequence flow '" + defaultSequenceFlow + "' not found");
                }
            }
            else {
                // No sequence flow could be found, not even a default one
                throw new ActivitiException("No outgoing sequence flow of the exclusive gateway '"
                    + execution.getActivity().getId() + "' could be selected for continuing the process");
            }
        }

    }
    
    /**
     * 
     * Description: 先根据conditionStr是否是IProcessExpression的实现类，如果是实现类，则执行
     * 
     * @author jinyanan
     *
     * @param condition IProcessExpression实现类的绝对地址
     * @param variables 流程参数
     * @return true-当前实现类返回true；false-当前实现类返回false或者conditionStr不是类绝对地址
     */
    private boolean getInstanceResult(Condition condition, Map<String, Object> variables) {
        try {
            Field expressionFiled = condition.getClass().getDeclaredField("initialConditionExpression");
            expressionFiled.setAccessible(true);
            String conditionStr = (String) expressionFiled.get(condition);
            if (StringUtil.isEmpty(conditionStr) || !conditionStr.startsWith("com")) {
                return false;
            }
            IProcessExpression expression = (IProcessExpression) Class.forName(conditionStr.toString()).newInstance();
            return expression.getResult(variables);
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchFieldException | SecurityException e) {
            logger.debug("cannot instance! The expression is not url.");
            return false;
        }
        
    }

}
