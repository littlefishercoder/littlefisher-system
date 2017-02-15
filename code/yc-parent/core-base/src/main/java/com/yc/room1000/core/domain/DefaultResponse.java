package com.yc.room1000.core.domain;

import java.io.Serializable;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月15日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class DefaultResponse implements Serializable {

    /**
     * serialVersionUID 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 报错的编码
     */
    private String errorCode = "0";
    
    /**
     * 报错的信息
     */
    private String errorMsg;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    
    
}
