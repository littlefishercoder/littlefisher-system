package com.littlefisher.core.aop;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.IValidator;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.littlefisher.core.stereotype.intf.ValidationHandler;

/**
 * Description: ControllerValidationAspect.java
 *
 * Created on 2018年02月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Component
@Aspect
public class ControllerValidationAspect implements ValidationHandler {

    @Autowired
    private IValidator validator;

    /**
     * 前置aop
     * @param jp joinPoint
     */
    @Before("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void processCheck(JoinPoint jp) {
        // 获取方法参数值
        Object[] args = jp.getArgs();

        for (Object arg : args) {
            List<ConstraintViolation> validations = validator.validate(arg);
            publishValidationMessage(validations, jp.getSignature()
                    .getName());
        }
    }
}
