package com.yc.core.attr.dto;

import java.io.Serializable;

/**
 * 
 * Description: 
 *  
 * Created on 2017年1月16日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class AttrCatgDto implements Serializable {
    /**
     * id 主键
     * @mbg.generated
     */
    private Long id;

    /**
     * catgName 目录名
     * @mbg.generated
     */
    private String catgName;

    /**
     * catgCode 目录编码
     * @mbg.generated
     */
    private String catgCode;

    /**
     * parentCatgId 父目录主键
     * @mbg.generated
     */
    private Long parentCatgId;

    /**
     * catgType 目录类型
     * @mbg.generated
     */
    private String catgType;

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

    public String getCatgName() {
        return catgName;
    }

    public void setCatgName(String catgName) {
        this.catgName = catgName == null ? null : catgName.trim();
    }

    public String getCatgCode() {
        return catgCode;
    }

    public void setCatgCode(String catgCode) {
        this.catgCode = catgCode == null ? null : catgCode.trim();
    }

    public Long getParentCatgId() {
        return parentCatgId;
    }

    public void setParentCatgId(Long parentCatgId) {
        this.parentCatgId = parentCatgId;
    }

    public String getCatgType() {
        return catgType;
    }

    public void setCatgType(String catgType) {
        this.catgType = catgType == null ? null : catgType.trim();
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
        sb.append(", catgName=").append(catgName);
        sb.append(", catgCode=").append(catgCode);
        sb.append(", parentCatgId=").append(parentCatgId);
        sb.append(", catgType=").append(catgType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}