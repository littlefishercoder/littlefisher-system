package com.littlefisher.core.activiti.ext;

import org.activiti.bpmn.model.ExclusiveGateway;
import org.activiti.engine.impl.bpmn.behavior.ExclusiveGatewayActivityBehavior;
import org.activiti.engine.impl.bpmn.parser.factory.DefaultActivityBehaviorFactory;

/**
 * 
 * Description: 
 * 发现可以使用UelExpression来执行复杂校验
 *  
 * Created on 2017年1月22日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Deprecated
public class ActivityBehaviorFactoryExt extends DefaultActivityBehaviorFactory {
    
    /**
     * exclusiveGatewayActivityBehaviorExt
     */
    private ExclusiveGatewayActivityBehaviorExt exclusiveGatewayActivityBehaviorExt;

    /**
     * 通过Spring容器注入新的分支条件行为执行类
     * 
     * @param exclusiveGatewayActivityBehaviorExt  exclusiveGatewayActivityBehaviorExt
     */
    public void setExclusiveGatewayActivityBehaviorExt(
        ExclusiveGatewayActivityBehaviorExt exclusiveGatewayActivityBehaviorExt) {
        this.exclusiveGatewayActivityBehaviorExt = exclusiveGatewayActivityBehaviorExt;
    }

    // 重写父类中的分支条件行为执行类
    @Override
    public ExclusiveGatewayActivityBehavior createExclusiveGatewayActivityBehavior(ExclusiveGateway exclusiveGateway) {
        return exclusiveGatewayActivityBehaviorExt;
    }
}
