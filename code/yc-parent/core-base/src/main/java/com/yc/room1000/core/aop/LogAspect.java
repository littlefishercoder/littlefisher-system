package com.yc.room1000.core.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

import com.yc.room1000.core.utils.Room1000Logger;

/**
 * Description: 日志拦截 
 * 
 * Created on 2017年1月4日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class LogAspect {

    /**
     * Description: 进入service前
     * 
     * @author jinyanan
     * @param joinPoint 切点
     */
    public void before(JoinPoint joinPoint) {
        Room1000Logger logger = Room1000Logger.getLogger(joinPoint.getTarget().getClass());
        String method = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        logger.debug(method + " begin------------------------------------------------------------------------");
        logger.debug("args: " + Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * 
     * Description: 出service时日志打印
     * 
     * @author jinyanan
     *
     * @param joinPoint joinPoint
     * @param returnValue returnValue
     */
    public void afterReturning(JoinPoint joinPoint, Object returnValue) {
        Room1000Logger logger = Room1000Logger.getLogger(joinPoint.getTarget().getClass());
        String method = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        logger.debug("return args: " + returnValue);
        logger.debug(method + " end--------------------------------------------------------------------------");
    }

}
