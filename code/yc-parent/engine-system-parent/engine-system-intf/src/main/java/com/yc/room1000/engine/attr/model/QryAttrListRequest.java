package com.yc.room1000.engine.attr.model;

import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 
 * Description: 
 *  
 * Created on 2017年3月1日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel(value = "查询Attr列表的入参条件")
public class QryAttrListRequest {

    /**
     * attrName
     */
    @ApiModelProperty(value = "属性名")
    private String attrName;
    
    /**
     * attrCode
     */
    @ApiModelProperty(value = "属性编码")
    private String attrCode;
    
    /**
     * attrIds
     */
    @ApiModelProperty(value = "属性主键列表")
    private List<Long> attrIds;

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getAttrCode() {
        return attrCode;
    }

    public void setAttrCode(String attrCode) {
        this.attrCode = attrCode;
    }

    public List<Long> getAttrIds() {
        return attrIds;
    }

    public void setAttrIds(List<Long> attrIds) {
        this.attrIds = attrIds;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("QryAttrListRequest [attrName=");
        builder.append(attrName);
        builder.append(", attrCode=");
        builder.append(attrCode);
        builder.append(", attrIds=");
        builder.append(attrIds);
        builder.append("]");
        return builder.toString();
    }
    
}
