package com.littlefisher.core.interceptor;

import javax.validation.Validation;
import javax.validation.Validator;
import java.lang.reflect.Field;
import java.util.Arrays;

import org.hibernate.validator.HibernateValidator;

import com.littlefisher.core.exception.BaseRuntimeException;
import com.littlefisher.core.utils.ExceptionHandler;
import com.littlefisher.core.utils.LittleFisherLogger;

/**
 * Description: ValidationInterceptor.java
 *
 * Created on 2017年11月15日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class ValidationInterceptor extends AbstractCommandInterceptor {

    private static LittleFisherLogger logger = LittleFisherLogger.getLogger(ValidationInterceptor.class);

    private Validator validator;

    @Override
    public <U> U execute(CommandConfig config, Command<U> command) {
        generateValidator();
        validateFields(command);
        return next.execute(config, command);
    }

    /**
     * 初始化Validator
     */
    private void generateValidator() {
        if (validator == null) {
            validator = Validation.byProvider(HibernateValidator.class).configure().failFast(true)
                    .buildValidatorFactory().getValidator();
        }
    }

    /**
     * 对command构造函数的入参进行校验
     *
     * @param command 具体业务command
     * @param <U> 返回参数类型
     */
    private <U> void validateFields(Command<U> command) {
        Class<?> clazz = command.getClass();
        Field[] fields = clazz.getDeclaredFields();
        if (fields.length == 0) {
            return;
        }
        Arrays.stream(fields).forEach(field -> validator.validate(getFieldVariable(command, field))
                .forEach(validation -> ExceptionHandler.publish("CORE-000009", null, validation.getMessage())));
    }

    /**
     * 获取clazz中field字段的属性值
     *
     * @param command 要获取字段的类
     * @param field 具体字段
     * @param <U> 泛型
     * @return 字段的值
     */
    @SuppressWarnings("Duplicates")
    private <U> Object getFieldVariable(Command<U> command, Field field) {
        try {
            field.setAccessible(true);
            return field.get(command);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            logger.error("inerror", e);
            throw new BaseRuntimeException("inerror", e);
        }
    }
}
