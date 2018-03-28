package com.littlefisher.core.biz.framework.dal.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 * Description: bfm_system_param 实体
 *
 * Created on 2018年01月10日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "bfm_system_param")
public class SystemParamDto implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * key值
     */
    @Column(name = "param_key")
    private String paramKey;

    /**
     * value值
     */
    @Column(name = "param_value")
    private String paramValue;

    /**
     * 默认值
     */
    @Column(name = "default_value")
    private String defaultValue;

    /**
     * 描述
     */
    @Column(name = "param_desc")
    private String paramDesc;

    public static class Builder {

        private SystemParamDto instance = new SystemParamDto();

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

        public SystemParamDto build() {
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
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", paramKey=").append(paramKey);
        sb.append(", paramValue=").append(paramValue);
        sb.append(", defaultValue=").append(defaultValue);
        sb.append(", paramDesc=").append(paramDesc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}