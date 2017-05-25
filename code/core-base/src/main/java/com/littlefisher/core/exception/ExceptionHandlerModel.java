package com.littlefisher.core.exception;

/**
 * 
 * Description: 统一异常处理返回信息
 *  
 * Created on 2017年5月25日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class ExceptionHandlerModel {
    
    /**
     * errorCode 异常编码
     */
    private String errorCode;
    
    /**
     * errorMsg 异常描述
     */
    private String errorMsg;

    /** 
     * Description: 构造函数
     *
     * @author jinyanan
     *
     * @param errorCode errorCode
     * @param errorMsg errorMsg 
     */ 
    public ExceptionHandlerModel(String errorCode, String errorMsg) {
        super();
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ExceptionHandlerModel [errorCode=");
        builder.append(errorCode);
        builder.append(", errorMsg=");
        builder.append(errorMsg);
        builder.append("]");
        return builder.toString();
    }
    

}
