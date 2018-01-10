package com.littlefisher.core.biz.framework.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

import com.littlefisher.core.biz.framework.enums.EnumUserContactStationState;
import com.littlefisher.core.biz.framework.enums.EnumUserContactStationType;
import com.littlefisher.core.enums.EnumBizBool;

/**
 *
 * Description: bfm_user_contact_station 实体
 *
 * Created on 2018年01月10日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "bfm_user_contact_station")
@ApiModel("bfm_user_contact_station实体")
public class UserContactStationDto implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户主键
     */
    @ApiModelProperty("用户主键")
    @Column(name = "user_id")
    private Long userId;

    /**
     * 联系点类型
     */
    @ApiModelProperty("联系点类型")
    private EnumUserContactStationType type;

    /**
     * 联系点状态
     */
    @ApiModelProperty("联系点状态")
    private EnumUserContactStationState state;

    /**
     * 是否默认联系点（一种联系点类型下最多一个默认）
     */
    @ApiModelProperty("是否默认联系点（一种联系点类型下最多一个默认）")
    @Column(name = "default_flag")
    private EnumBizBool defaultFlag;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    @Column(name = "update_date")
    private Date updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public EnumUserContactStationType getType() {
        return type;
    }

    public void setType(EnumUserContactStationType type) {
        this.type = type;
    }

    public EnumUserContactStationState getState() {
        return state;
    }

    public void setState(EnumUserContactStationState state) {
        this.state = state;
    }

    public EnumBizBool getDefaultFlag() {
        return defaultFlag;
    }

    public void setDefaultFlag(EnumBizBool defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", type=").append(type);
        sb.append(", state=").append(state);
        sb.append(", defaultFlag=").append(defaultFlag);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}