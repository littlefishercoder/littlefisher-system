package com.littlefisher.core.stereotype.intf;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.context.ClassContext;
import net.sf.oval.context.FieldContext;
import net.sf.oval.context.OValContext;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.google.common.collect.Lists;
import com.littlefisher.core.utils.CollectionUtil;
import com.littlefisher.core.utils.ExceptionHandler;

/**
 * Description: ValidationHandler.java
 *
 * Created on 2018年02月05日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface ValidationHandler {

    /**
     * 查找最根本的校验问题
     * @param violationList 校验
     * @param location 校验字段位置
     */
    default void publishValidationMessage(List<ConstraintViolation> violationList, String location) {
        if (CollectionUtil.isNotEmpty(violationList)) {
            for (ConstraintViolation constraintViolation : violationList) {
                if (ArrayUtils.isNotEmpty(constraintViolation.getCauses())) {
                    OValContext oValContext = constraintViolation.getContext();
                    if (oValContext instanceof FieldContext) {
                        FieldContext fieldContext = (FieldContext) oValContext;
                        location += "." + fieldContext.getField().getName();
                    } else if (oValContext instanceof ClassContext) {
                        ClassContext classContext = (ClassContext) oValContext;
                        location += "." + classContext.getClazz().getSimpleName();
                    }
                    publishValidationMessage(Lists.newArrayList(constraintViolation.getCauses()), location);
                } else {
                    ExceptionHandler.publish("CORE-000009", null, location, constraintViolation.getMessage());
                }
            }
        }
    }
}
