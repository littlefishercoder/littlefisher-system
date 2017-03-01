package com.yc.room1000.engine.attr.model;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *
 * Description: attr_value实体
 *
 * Created on 2017年03月01日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel(value = "attr_value实体")
public class AttrValueDto implements Serializable {
    /**
     * id 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * attrId 属性主键
     */
    @ApiModelProperty(value = "属性主键")
    private Long attrId;

    /**
     * value 属性可选项
     */
    @ApiModelProperty(value = "属性可选项")
    private String value;

    /**
     * valueMask 可选项展示内容
     */
    @ApiModelProperty(value = "可选项展示内容")
    private String valueMask;

    /**
     * priority 优先级
     */
    @ApiModelProperty(value = "优先级")
    private Long priority;

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

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getValueMask() {
        return valueMask;
    }

    public void setValueMask(String valueMask) {
        this.valueMask = valueMask == null ? null : valueMask.trim();
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    /**
     * Description: toString<br>
     *
     * @author jinyanan <br>
    
     * @return String String<br>
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", attrId=").append(attrId);
        sb.append(", value=").append(value);
        sb.append(", valueMask=").append(valueMask);
        sb.append(", priority=").append(priority);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}