package com.littlefisher.core.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

import com.littlefisher.core.utils.LittleFisherLogger;

/**
 * 
 * Description: 对Controller日志拦截
 *  
 * Created on 2017年4月17日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class LoggerAspect4Controller {

	/**
     * 
     * Description: 环绕通知
     * 
     * @author jinyanan
     *
     * @param jp
     * @throws Throwable
     */
    public Object doInMethod(ProceedingJoinPoint jp) throws Throwable {
        LittleFisherLogger logger = LittleFisherLogger.getLogger(jp.getTarget().getClass());
        String methodName = jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName();
        try {
            logger.info(methodName + " controller begin------------------------------------------------------------------------");
            if (jp.getArgs().length > 0) {
                logger.debug("Parameters: " + Arrays.toString(jp.getArgs()));
            }
            
            Object returnValue = jp.proceed();
            
            if (returnValue != null) {
                logger.debug("return agrs: " + returnValue);
            }
            logger.info(methodName + " controller end--------------------------------------------------------------------------");
            return returnValue;
        }
        catch (Throwable e) {
            logger.info(methodName + " controller throw an exception-----------------------------------------------------------");
            throw e;
        }
    }
}
