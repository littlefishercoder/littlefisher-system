package com.littlefisher.core.aop;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.Set;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.validator.HibernateValidator;
import org.springframework.stereotype.Component;

import com.littlefisher.core.utils.CollectionUtil;
import com.littlefisher.core.utils.ExceptionHandler;

/**
 * Description: ControllerValidation.java
 *
 * Created on 2018年02月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Component
@Aspect
public class ControllerValidation {

    private Validator validator;

    /**
     * 初始化Validator
     */
    private void generateValidator() {
        if (validator == null) {
            validator = Validation.byProvider(HibernateValidator.class)
                    .configure()
                    .failFast(true)
                    .buildValidatorFactory()
                    .getValidator();
        }
    }

    /**
     * 循环aop
     * @param pjp joinPoint
     * @return 返回值
     * @throws Throwable 异常
     */
    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object processCheck(ProceedingJoinPoint pjp) throws Throwable {
        generateValidator();
        // 获取方法参数值
        Object[] args = pjp.getArgs();

        for (Object arg : args) {
            Set<ConstraintViolation<Object>> validations = validator.validate(arg);
            if (CollectionUtil.isNotEmpty(validations)) {
                validations.forEach(violation -> ExceptionHandler.publish("CORE-000009", null, violation.getMessage()));
            }
        }
        return pjp.proceed();
    }

}
