package com.yc.room1000.core.exception;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月10日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class BaseRuntimeException extends RuntimeException {

    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * BaseRuntimeException
     */
    public BaseRuntimeException() {
        super();
    }
    
    /**
     * BaseRuntimeException
     * @param message <br>
     * @param cause <br>
     */
    public BaseRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
