package com.yc.room1000.engine.attr.model;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *
 * Description: attr_catg_type实体
 *
 * Created on 2017年03月01日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel(value = "attr_catg_type实体")
public class AttrCatgTypeDto implements Serializable {
    /**
     * type 类型
     */
    @ApiModelProperty(value = "类型")
    private String type;

    /**
     * typeName 类型名
     */
    @ApiModelProperty(value = "类型名")
    private String typeName;

    /**
     * typeNameEn 类型名 英文
     */
    @ApiModelProperty(value = "类型名 英文")
    private String typeNameEn;

    /**
     * comments 备注
     */
    @ApiModelProperty(value = "备注")
    private String comments;

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getTypeNameEn() {
        return typeNameEn;
    }

    public void setTypeNameEn(String typeNameEn) {
        this.typeNameEn = typeNameEn == null ? null : typeNameEn.trim();
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
        sb.append(", type=").append(type);
        sb.append(", typeName=").append(typeName);
        sb.append(", typeNameEn=").append(typeNameEn);
        sb.append(", comments=").append(comments);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}