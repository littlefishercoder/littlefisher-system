package com.yc.room1000.attr.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * Description: attr 实体
 *
 * Created on 2017年03月05日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "attr")
@ApiModel(value = "attr实体")
public class AttrDto implements Serializable {
    /**
     * 属性主键
     */
    @ApiModelProperty(value = "属性主键")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 属性名
     */
    @ApiModelProperty(value = "属性名")
    private String name;

    /**
     * 属性编码
     */
    @ApiModelProperty(value = "属性编码")
    private String code;

    /**
     * 单位
     */
    @ApiModelProperty(value = "单位")
    @Column(name = "unit_id")
    private Long unitId;

    /**
     * 属性类型
     */
    @ApiModelProperty(value = "属性类型")
    private String type;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String state;

    /**
     * 状态变更时间
     */
    @ApiModelProperty(value = "状态变更时间")
    @Column(name = "state_date")
    private Date stateDate;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String comments;

    /**
     * Y ——必填，N——非必填。default N
     */
    @ApiModelProperty(value = "Y ——必填，N——非必填。default N")
    private String mandatory;

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
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
        this.comments = comments;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
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
        sb.append(", name=").append(name);
        sb.append(", code=").append(code);
        sb.append(", unitId=").append(unitId);
        sb.append(", type=").append(type);
        sb.append(", state=").append(state);
        sb.append(", stateDate=").append(stateDate);
        sb.append(", comments=").append(comments);
        sb.append(", mandatory=").append(mandatory);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}