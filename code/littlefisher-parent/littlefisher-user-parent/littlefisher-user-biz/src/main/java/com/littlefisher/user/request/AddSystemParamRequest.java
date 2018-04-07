package com.littlefisher.user.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.sf.oval.constraint.CheckWith;
import net.sf.oval.constraint.CheckWithCheck;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

import java.io.Serializable;

import com.littlefisher.core.common.utils.StringUtil;

/**
 * Description: AddSystemParamRequest.java
 *
 * Created on 2018年02月05日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("新增系统参数请求")
public class AddSystemParamRequest implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 9218534508875168010L;

    /**
     * key值
     */
    @ApiModelProperty(required = true, value = "key值")
    @NotBlank(message = "key不能为空")
    @NotNull(message = "key不能为空")
    private String paramKey;

    /**
     * value值
     */
    @ApiModelProperty("value值")
    @CheckWith(value = ValueCheck.class, message = "paramValue和defaultValue不能同时为空")
    private String paramValue;

    /**
     * 默认值
     */
    @ApiModelProperty("默认值")
    private String defaultValue;

    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String paramDesc;

    public static class ValueCheck implements CheckWithCheck.SimpleCheck {

        /** serialVersionUID */
        private static final long serialVersionUID = -1025625814757483862L;

        @Override
        public boolean isSatisfied(Object validatedObject, Object value) {
            AddSystemParamRequest request = (AddSystemParamRequest) validatedObject;
            String paramValue = (String) value;
            return StringUtil.isNotBlank(request.getDefaultValue()) || StringUtil.isNotBlank(paramValue);
        }
    }

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getParamDesc() {
        return paramDesc;
    }

    public void setParamDesc(String paramDesc) {
        this.paramDesc = paramDesc;
    }

    @Override
    public String toString() {
        return "AddSystemParamRequest{" + "paramKey='" + paramKey + '\'' + ", paramValue='" + paramValue + '\'' +
                ", defaultValue='" + defaultValue + '\'' + ", paramDesc='" + paramDesc + '\'' + '}';
    }
}
