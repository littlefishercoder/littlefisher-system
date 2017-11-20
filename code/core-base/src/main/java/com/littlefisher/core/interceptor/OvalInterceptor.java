package com.littlefisher.core.interceptor;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import java.lang.reflect.Field;
import java.util.List;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.littlefisher.core.exception.BaseRuntimeException;
import com.littlefisher.core.interceptor.cfg.EnumOvalErrorCode;
import com.littlefisher.core.utils.CollectionUtil;
import com.littlefisher.core.utils.ExceptionHandler;
import com.littlefisher.core.utils.LittleFisherLogger;

/**
 * Description: OvalInterceptor.java
 *
 * Created on 2017年11月15日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class OvalInterceptor extends AbstractCommandInterceptor {

    private static LittleFisherLogger logger = LittleFisherLogger.getLogger(OvalInterceptor.class);

    @Override
    public <U> U execute(CommandConfig config, Command<U> command) {
        validateFields(command);
        return next.execute(config, command);
    }

    /**
     * 对command构造函数的入参进行oval校验
     * @param command 具体业务command
     * @param <U> 返回参数类型
     */
    private <U> void validateFields(Command<U> command) {
        Class<?> clazz = command.getClass();
        Field[] fields = clazz.getDeclaredFields();
        if (fields.length == 0) {
            return;
        }
        List<ConstraintViolation> constraintViolationList = Lists.newArrayList();
        for (Field field : fields) {
            Object fieldObj = getFieldVariable(command, field);
            Validator validator = new Validator();
            constraintViolationList.addAll(validator.validate(fieldObj));
        }

        if (CollectionUtil.isNotEmpty(constraintViolationList)) {
            constraintViolationList.forEach(input -> {
                logger.error(
                        EnumOvalErrorCode.find(input.getErrorCode()).getDescription() + "[" + input.getMessage() + "]");
            });
            ConstraintViolation firstConstraintViolation = Iterables.get(constraintViolationList, 0);
            ExceptionHandler.publish(firstConstraintViolation.getErrorCode(),
                    EnumOvalErrorCode.find(firstConstraintViolation.getErrorCode()).getDescription() + "["
                    + firstConstraintViolation.getMessage() + "]");
        }
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
