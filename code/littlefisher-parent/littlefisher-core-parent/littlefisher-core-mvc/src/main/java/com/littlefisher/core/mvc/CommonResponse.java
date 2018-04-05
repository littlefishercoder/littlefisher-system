package com.littlefisher.core.mvc;

import java.io.Serializable;

import com.littlefisher.core.common.stereotype.enums.EnumResult;

/**
 * Description: CommonResponse.java
 *
 * Created on 2018年02月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class CommonResponse implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -3916347410797406289L;

    /** 请求成功与否 */
    private EnumResult result;

    /** 返回的数据 */
    private Object data;

    /** 请求失败时的错误码 */
    private String errorCode;

    /** 请求失败时的错误信息 */
    private String errorMsg;

    public CommonResponse() {
    }

    public CommonResponse(EnumResult result, String errorCode, String errorMsg) {
        this.result = result;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public CommonResponse(EnumResult result, Object data) {

        this.result = result;
        this.data = data;
    }

    public EnumResult getResult() {
        return result;
    }

    public void setResult(EnumResult result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
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
        return "CommonResponse{" + "result=" + result + ", data=" + data + ", errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' + '}';
    }
}
