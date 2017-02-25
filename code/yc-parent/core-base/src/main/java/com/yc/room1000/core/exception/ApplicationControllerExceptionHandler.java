package com.yc.room1000.core.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.yc.room1000.core.utils.Room1000Logger;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月23日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ControllerAdvice
public class ApplicationControllerExceptionHandler {
    
    /**
     * logger
     */
    private static Room1000Logger logger = Room1000Logger.getLogger(ApplicationControllerExceptionHandler.class);
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param ex ex
     * @return Map<String, Object>
     */
    @ExceptionHandler(value = BaseAppException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, Object> handlerError(BaseAppException ex) {
        logger.error(ex.getMessage(), ex);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("errorCode", ex.getCode());
        map.put("errorMsg", ex.getLocaleMessage());
        return map;
    }
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param ex ex
     * @return Map<String, Object>
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, Object> handlerError(Exception ex) {
        logger.error(ex.getMessage(), ex);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("errorMsg", ex.getMessage());
        return map;
    }
    
}
