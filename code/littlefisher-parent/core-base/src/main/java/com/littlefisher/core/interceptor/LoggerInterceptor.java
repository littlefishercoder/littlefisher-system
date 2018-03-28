package com.littlefisher.core.interceptor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Map;

import com.github.pagehelper.util.StringUtil;
import com.google.common.collect.Maps;
import com.littlefisher.core.exception.BaseRuntimeException;
import com.littlefisher.core.utils.LittleFisherLogger;

/**
 * Description: 日志打印拦截器
 *
 * Created on 2017年5月11日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class LoggerInterceptor extends AbstractCommandInterceptor {

    /**
     * logger
     */
    private static LittleFisherLogger logger = LittleFisherLogger.getLogger(LoggerInterceptor.class);

    @Override
    public <U> U execute(CommandConfig config, Command<U> command) {
        Class<?> clazz = command.getClass();
        String parameters = this.getCommandParameters(command);
        String methodName = clazz.getSimpleName();
        LittleFisherLogger clazzLogger = LittleFisherLogger.getLogger(clazz);
        U result;
        try {
            clazzLogger.info("--- starting {} --------------------------------------------------------", methodName);
            if (StringUtil.isNotEmpty(parameters)) {
                clazzLogger.info("Parameters:" + parameters);
            }
            result = next.execute(config, command);
            if (result != null) {
                clazzLogger.debug("return agrs:" + result);
            }
            return result;
        } catch (Exception e) {
            clazzLogger.error("inerror", e);
            throw new BaseRuntimeException("inerror", e);
        } finally {
            clazzLogger.info("--- {} finished --------------------------------------------------------", methodName);
        }
    }

    /**
     * Description: 获取clazz构造函数的入参
     */
    private <U> String getCommandParameters(Command<U> command) {
        Class<?> clazz = command.getClass();
        Field[] fields = clazz.getDeclaredFields();
        if (fields.length == 0) {
            return null;
        }
        Map<Class<?>, Object> fieldMap = Maps.newHashMap();
        for (Field field : fields) {
            fieldMap.put(field.getType(), getFieldVariable(command, field));
        }

        return buildParameterStr(fieldMap, clazz);
    }

    /**
     * Description: 构造参数字符串
     */
    private String buildParameterStr(Map<Class<?>, Object> fieldMap, Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getConstructors();
        // 构造函数有且只有一个，如果后续有变动，再修改
        Constructor<?> constructor = constructors[0];
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        StringBuilder sb = new StringBuilder();

        sb.append(" [");
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> parameterType = parameterTypes[i];
            sb.append(i == 0 ? " " : ", ").append(parameterType.getName()).append("=")
                    .append(fieldMap.get(parameterType));
        }
        sb.append(" ]");
        return sb.toString();
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
