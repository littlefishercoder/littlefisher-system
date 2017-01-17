package com.yc.room1000.core.attr.dto;

import java.io.Serializable;
import java.util.Date;

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
     * catgType 目录类型
     * @mbg.generated
     */
    private String catgType;

    /**
     * state 状态
     * @mbg.generated
     */
    private String state;

    /**
     * stateDate 状态变更时间
     * @mbg.generated
     */
    private Date stateDate;

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

    public String getCatgType() {
        return catgType;
    }

    public void setCatgType(String catgType) {
        this.catgType = catgType == null ? null : catgType.trim();
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
        sb.append(", catgType=").append(catgType);
        sb.append(", state=").append(state);
        sb.append(", stateDate=").append(stateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}