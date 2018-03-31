package com.littlefisher.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *
 * @author jinyn22648
 * @version $$Id: SystemParamBizDto.java, v 0.1 2018/3/23 下午4:06 jinyn22648 Exp $$
 */
@ApiModel("系统参数")
public class SystemParamBizDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -6593510836212890908L;

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private Long id;

    /**
     * key值
     */
    @ApiModelProperty("key值")
    private String paramKey;

    /**
     * value值
     */
    @ApiModelProperty("value值")
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

    public static class Builder {

        private SystemParamBizDto instance = new SystemParamBizDto();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addId(Long id) {
            this.instance.setId(id);
            return this;
        }

        public Builder addParamKey(String paramKey) {
            this.instance.setParamKey(paramKey);
            return this;
        }

        public Builder addParamValue(String paramValue) {
            this.instance.setParamValue(paramValue);
            return this;
        }

        public Builder addDefaultValue(String defaultValue) {
            this.instance.setDefaultValue(defaultValue);
            return this;
        }

        public Builder addParamDesc(String paramDesc) {
            this.instance.setParamDesc(paramDesc);
            return this;
        }

        public SystemParamBizDto build() {
            return this.instance;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "SystemParamBizDto{" + "id=" + id + ", paramKey='" + paramKey + '\'' + ", paramValue='" + paramValue
            + '\'' + ", defaultValue='" + defaultValue + '\'' + ", paramDesc='" + paramDesc + '\'' + '}';
    }
}
