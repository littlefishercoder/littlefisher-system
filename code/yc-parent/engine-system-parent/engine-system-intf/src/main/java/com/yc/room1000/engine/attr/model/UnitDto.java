package com.yc.room1000.engine.attr.model;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *
 * Description: unit实体
 *
 * Created on 2017年03月01日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel(value = "unit实体")
public class UnitDto implements Serializable {
    /**
     * unit 单位
     */
    @ApiModelProperty(value = "单位")
    private Long unit;

    /**
     * unitName 单位名称
     */
    @ApiModelProperty(value = "单位名称")
    private String unitName;

    /**
     * precision 精度，可空，代表没有精度需求。例如千克的精度为3，则数据库中存123456时，实际的数据应该是123.456千克
     */
    @ApiModelProperty(value = "精度，可空，代表没有精度需求。例如千克的精度为3，则数据库中存123456时，实际的数据应该是123.456千克")
    private Long precision;

    /**
     * comments 备注
     */
    @ApiModelProperty(value = "备注")
    private String comments;

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    public Long getUnit() {
        return unit;
    }

    public void setUnit(Long unit) {
        this.unit = unit;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    public Long getPrecision() {
        return precision;
    }

    public void setPrecision(Long precision) {
        this.precision = precision;
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
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", unit=").append(unit);
        sb.append(", unitName=").append(unitName);
        sb.append(", precision=").append(precision);
        sb.append(", comments=").append(comments);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}