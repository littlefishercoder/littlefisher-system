package com.littlefisher.core.interceptor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.github.pagehelper.util.StringUtil;
import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.exception.BaseRuntimeException;
import com.littlefisher.core.utils.LittleFisherLogger;

/**
 * 
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
    public <U> U execute(CommandConfig config, Command<U> command) throws BaseAppException {
        Class<?> clazz = command.getClass();
        String parameters = this.getCommandParameters(command);
        String methodName = clazz.getSimpleName();
        LittleFisherLogger clazzLlogger = LittleFisherLogger.getLogger(clazz);
        U result = null;
        try {
            clazzLlogger.info("--- starting {} --------------------------------------------------------", methodName);
            if (StringUtil.isNotEmpty(parameters)) {
                clazzLlogger.info("Parameters:" + parameters);
            }
            result = next.execute(config, command);
            if (result != null) {
                clazzLlogger.debug("return agrs:" + result);
            }
            return result;
        }
        catch (Exception e) {
            clazzLlogger.error("inerror", e);
            throw new BaseRuntimeException("inerror", e);
        }
        finally {
            clazzLlogger.info("--- {} finished --------------------------------------------------------", methodName);
        }
    }
    
    /**
     * 
     * Description: 获取clazz构造函数的入参
     * 
     * @author jinyanan
     *
     * @param command command
     * @param <U> <U>
     * @return String <br>
     */
    private <U> String getCommandParameters(Command<U> command) {
        Class<?> clazz = command.getClass();
        Field[] fields = clazz.getDeclaredFields();
        if (fields.length == 0) {
            return null;
        }
        Map<Class<?>, Object> fieldMap = new HashMap<>();
        for (Field field : fields) {
            fieldMap.put(field.getType(), getFieldVariable(command, field));
        }
        
        return buildParameterStr(fieldMap, clazz);
    }

    /**
     * 
     * Description: 构造参数字符串
     * 
     * @author jinyanan
     *
     * @param fieldMap fieldMap
     * @param clazz clazz
     * @return String
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
            if (i == 0) {
                sb.append(" " + parameterType.getName() + "=").append(fieldMap.get(parameterType));
            }
            else {
                sb.append(", " + parameterType.getName() + "=").append(fieldMap.get(parameterType));
            }
        }
        sb.append(" ]");
        return sb.toString();
    }

    /**
     * 
     * Description: 获取clazz中field字段的属性值
     * 
     * @author jinyanan
     *
     * @param command command
     * @param field field
     * @param <U> <U>
     * @return Object
     */
    private <U> Object getFieldVariable(Command<U> command, Field field) {
        try {
            field.setAccessible(true);
            return field.get(command);
        }
        catch (IllegalArgumentException | IllegalAccessException e) {
            logger.error("inerror", e);
            throw new BaseRuntimeException("inerror", e);
        }
    }

}
