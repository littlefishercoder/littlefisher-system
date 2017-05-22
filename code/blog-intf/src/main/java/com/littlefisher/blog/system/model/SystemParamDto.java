package com.littlefisher.blog.system.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;


/**
 *
 * Description: system_param 实体
 *
 * Created on 2017年05月22日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "system_param")
@ApiModel(value = "system_param实体")
public class SystemParamDto implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * key值
     */
    @ApiModelProperty(value = "key值")
    @Column(name = "param_key")
    private String paramKey;

    /**
     * value值
     */
    @ApiModelProperty(value = "value值")
    @Column(name = "param_value")
    private String paramValue;

    /**
     * 默认值
     */
    @ApiModelProperty(value = "默认值")
    @Column(name = "default_value")
    private String defaultValue;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    @Column(name = "param_desc")
    private String paramDesc;

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

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

    /**
     * Description: toString<br>
     *
     * @author autoCreated <br>
    
     * @return String String<br>
     * @mbg.generated
     */
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