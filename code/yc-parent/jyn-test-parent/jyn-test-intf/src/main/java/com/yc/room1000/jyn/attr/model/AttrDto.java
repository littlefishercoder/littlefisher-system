package com.yc.room1000.jyn.attr.model;

import java.io.Serializable;
import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月11日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel(value = "请求参数实体")
public class AttrDto implements Serializable {
    /**
     * id 属性主键
     * @mbg.generated
     */
    @ApiModelProperty(value = "属性主键")
    private Long id;

    /**
     * name 属性名
     * @mbg.generated
     */
    @ApiModelProperty(value = "属性名")
    private String name;

    /**
     * code 属性编码
     * @mbg.generated
     */
    @ApiModelProperty(value = "属性编码")
    private String code;

    /**
     * unitId 单位
     * @mbg.generated
     */
    @ApiModelProperty(value = "单位")
    private Long unitId;

    /**
     * type 属性类型
     * @mbg.generated
     */
    @ApiModelProperty(value = "属性类型")
    private String type;

    /**
     * state 状态
     * @mbg.generated
     */
    @ApiModelProperty(value = "状态")
    private String state;

    /**
     * stateDate 状态变更时间
     * @mbg.generated
     */
    @ApiModelProperty(value = "状态变更时间")
    private Date stateDate;

    /**
     * comments 备注
     * @mbg.generated
     */
    @ApiModelProperty(value = "备注")
    private String comments;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getStateDate() {
        return stateDate;
    }

    public void setStateDate(Date stateDate) {
        this.stateDate = stateDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    /**
     * Description: toString<br>
     *
     * @author jinyanan <br>
    
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
        sb.append(", name=").append(name);
        sb.append(", code=").append(code);
        sb.append(", unitId=").append(unitId);
        sb.append(", type=").append(type);
        sb.append(", state=").append(state);
        sb.append(", stateDate=").append(stateDate);
        sb.append(", comments=").append(comments);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}