package com.yc.room1000.jyn.attr.model;

import java.io.Serializable;
import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月26日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel(value = "查询Attr列表的请求参数")
public class QryAttrListRequest implements Serializable {

    /**
     * serialVersionUID 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * attrIds attrId的集合
     */
    @ApiModelProperty(value = "attrId的集合")
    private List<String> attrIds;
    
    /**
     * attrName 属性名
     */
    @ApiModelProperty(value = "属性名")
    private String attrName;
    
    /**
     * attrCode 属性编码
     */
    @ApiModelProperty(value = "属性编码")
    private String attrCode;

    public List<String> getAttrIds() {
        return attrIds;
    }

    public void setAttrIds(List<String> attrIds) {
        this.attrIds = attrIds;
    }

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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("QryAttrListRequest [attrIds=");
        builder.append(attrIds);
        builder.append(", attrName=");
        builder.append(attrName);
        builder.append(", attrCode=");
        builder.append(attrCode);
        builder.append("]");
        return builder.toString();
    }


}
