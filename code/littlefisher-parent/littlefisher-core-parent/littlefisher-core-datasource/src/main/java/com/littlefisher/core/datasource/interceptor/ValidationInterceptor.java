package com.littlefisher.core.datasource.interceptor;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.IValidator;
import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AnnotationsConfigurer;
import net.sf.oval.configuration.annotation.BeanValidationAnnotationsConfigurer;

import java.util.List;

import com.littlefisher.core.common.utils.LittleFisherLogger;
import com.littlefisher.core.validation.handler.ValidationHandler;

/**
 * Description: ValidationInterceptor.java
 *
 * Created on 2017年11月15日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class ValidationInterceptor extends AbstractCommandInterceptor implements ValidationHandler {

    private static LittleFisherLogger logger = LittleFisherLogger.getLogger(ValidationInterceptor.class);

    private IValidator validator = new Validator(new BeanValidationAnnotationsConfigurer(),
            new AnnotationsConfigurer());

    @Override
    public <U> U execute(CommandConfig config, Command<U> command) {
        logger.debug("Command层参数校验");
        List<ConstraintViolation> violationList = validator.validate(command);
        publishValidationMessage(violationList, command.getClass()
                .getSimpleName());
        return next.execute(config, command);
    }

}
