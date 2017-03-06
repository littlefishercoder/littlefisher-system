package com.yc.room1000.attr.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "attr")
public class AttrDto {
    /**
     * 属性主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 属性名
     */
    private String name;

    /**
     * 属性编码
     */
    private String code;

    /**
     * 单位
     */
    @Column(name = "unit_id")
    private Integer unitId;

    /**
     * 属性类型
     */
    private String type;

    /**
     * 状态
     */
    private String state;

    /**
     * 状态变更时间
     */
    @Column(name = "state_date")
    private Date stateDate;

    /**
     * 备注
     */
    private String comments;

    /**
     * Y ——必填，N——非必填。default N
     */
    private String mandatory;

    /**
     * 获取属性主键
     *
     * @return id - 属性主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置属性主键
     *
     * @param id 属性主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取属性名
     *
     * @return name - 属性名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置属性名
     *
     * @param name 属性名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取属性编码
     *
     * @return code - 属性编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置属性编码
     *
     * @param code 属性编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取单位
     *
     * @return unit_id - 单位
     */
    public Integer getUnitId() {
        return unitId;
    }

    /**
     * 设置单位
     *
     * @param unitId 单位
     */
    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    /**
     * 获取属性类型
     *
     * @return type - 属性类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置属性类型
     *
     * @param type 属性类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取状态
     *
     * @return state - 状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置状态
     *
     * @param state 状态
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取状态变更时间
     *
     * @return state_date - 状态变更时间
     */
    public Date getStateDate() {
        return stateDate;
    }

    /**
     * 设置状态变更时间
     *
     * @param stateDate 状态变更时间
     */
    public void setStateDate(Date stateDate) {
        this.stateDate = stateDate;
    }

    /**
     * 获取备注
     *
     * @return comments - 备注
     */
    public String getComments() {
        return comments;
    }

    /**
     * 设置备注
     *
     * @param comments 备注
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * 获取Y ——必填，N——非必填。default N
     *
     * @return mandatory - Y ——必填，N——非必填。default N
     */
    public String getMandatory() {
        return mandatory;
    }

    /**
     * 设置Y ——必填，N——非必填。default N
     *
     * @param mandatory Y ——必填，N——非必填。default N
     */
    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }
}