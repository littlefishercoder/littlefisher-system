package com.littlefisher.core.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.littlefisher.core.utils.LittleFisherLogger;

/**
 * Description: 对Service日志拦截 Created on 2017年1月4日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Aspect
public class LoggerAspect {
    
    /**
     * Description: 环绕Service通知
     * 
     * @author jinyanan
     * @param jp jp
     * @return Object
     * @throws Throwable Throwable
     */
    @Around("@within(org.springframework.stereotype.Service)")
    public Object aroundService(ProceedingJoinPoint jp) throws Throwable {
        LittleFisherLogger logger = LittleFisherLogger.getLogger(jp.getTarget().getClass());
        String methodName = jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName();
        try {
            logger.info(
                methodName + " service begin------------------------------------------------------------------------");
            if (jp.getArgs().length > 0) {
                logger.debug("Parameters: " + Arrays.toString(jp.getArgs()));
            }

            Object returnValue = jp.proceed();

            if (returnValue != null) {
                logger.debug("return agrs: " + returnValue);
            }
            logger.info(
                methodName + " service end--------------------------------------------------------------------------");
            return returnValue;
        }
        catch (Throwable e) {
            logger.info(
                methodName + " service throw an exception-----------------------------------------------------------");
            throw e;
        }
    }
    
    /**
     * 
     * Description: 环绕Controller通知
     * 
     * @author jinyanan
     *
     * @param jp jp
     * @return Object
     * @throws Throwable Throwable
     */
    @Around("@within(org.springframework.web.bind.annotation.RestController)")
    public Object aroundController(ProceedingJoinPoint jp) throws Throwable {
        LittleFisherLogger logger = LittleFisherLogger.getLogger(jp.getTarget().getClass());
        String methodName = jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName();
        try {
            logger.info(methodName
                + " controller begin------------------------------------------------------------------------");
            if (jp.getArgs().length > 0) {
                logger.debug("Parameters: " + Arrays.toString(jp.getArgs()));
            }

            Object returnValue = jp.proceed();

            if (returnValue != null) {
                logger.debug("return agrs: " + returnValue);
            }
            logger.info(methodName
                + " controller end--------------------------------------------------------------------------");
            return returnValue;
        }
        catch (Throwable e) {
            logger.info(methodName
                + " controller throw an exception-----------------------------------------------------------");
            throw e;
        }
    }

}
