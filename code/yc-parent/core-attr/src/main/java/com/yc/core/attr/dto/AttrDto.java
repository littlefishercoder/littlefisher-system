package com.yc.core.attr.dto;

import java.io.Serializable;

public class AttrDto implements Serializable {
    /**
     * id 属性主键
     * @mbg.generated
     */
    private Integer id;

    /**
     * name 属性名
     * @mbg.generated
     */
    private String name;

    /**
     * code 属性编码
     * @mbg.generated
     */
    private String code;

    /**
     * catgId 属性目录主键
     * @mbg.generated
     */
    private Integer catgId;

    /**
     * unitId 单位
     * @mbg.generated
     */
    private Integer unitId;

    /**
     * type 属性类型
     * @mbg.generated
     */
    private String type;

    /**
     * comments 备注
     * @mbg.generated
     */
    private String comments;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getCatgId() {
        return catgId;
    }

    public void setCatgId(Integer catgId) {
        this.catgId = catgId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }
}