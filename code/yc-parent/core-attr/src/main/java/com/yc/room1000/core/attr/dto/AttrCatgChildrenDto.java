package com.yc.room1000.core.attr.dto;

import java.io.Serializable;

/**
 * 
 * Description: 
 *  
 * Created on 2017年1月17日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class AttrCatgChildrenDto implements Serializable {
    /**
     * id 主键
     * @mbg.generated
     */
    private Long id;

    /**
     * catgId 当前目录主键
     * @mbg.generated
     */
    private Long catgId;

    /**
     * childCatgId 子目录主键
     * @mbg.generated
     */
    private Long childCatgId;

    /**
     * childAttrId 子属性主键
     * @mbg.generated
     */
    private Long childAttrId;

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

    public Long getCatgId() {
        return catgId;
    }

    public void setCatgId(Long catgId) {
        this.catgId = catgId;
    }

    public Long getChildCatgId() {
        return childCatgId;
    }

    public void setChildCatgId(Long childCatgId) {
        this.childCatgId = childCatgId;
    }

    public Long getChildAttrId() {
        return childAttrId;
    }

    public void setChildAttrId(Long childAttrId) {
        this.childAttrId = childAttrId;
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
        sb.append(", catgId=").append(catgId);
        sb.append(", childCatgId=").append(childCatgId);
        sb.append(", childAttrId=").append(childAttrId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}