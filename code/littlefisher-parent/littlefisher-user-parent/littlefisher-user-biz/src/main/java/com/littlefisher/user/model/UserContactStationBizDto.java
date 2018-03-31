package com.littlefisher.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import com.littlefisher.user.common.enums.EnumUserContactStationState;
import com.littlefisher.user.common.enums.EnumUserContactStationType;
import com.littlefisher.core.stereotype.enums.EnumBizBool;

/**
 *
 * Description: bfm_user_contact_station 实体
 *
 * Created on 2018年01月10日
 * 
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("联系点")
public class UserContactStationBizDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 3106333790895765787L;

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private Long id;

    /**
     * 用户主键
     */
    @ApiModelProperty("用户主键")
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
    private EnumBizBool defaultFlag;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createDate;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date updateDate;

    public static class Builder {

        private UserContactStationBizDto instance = new UserContactStationBizDto();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addId(Long id) {
            this.instance.setId(id);
            return this;
        }

        public Builder addUserId(Long userId) {
            this.instance.setUserId(userId);
            return this;
        }

        public Builder addType(EnumUserContactStationType type) {
            this.instance.setType(type);
            return this;
        }

        public Builder addState(EnumUserContactStationState state) {
            this.instance.setState(state);
            return this;
        }

        public Builder addDefaultFlag(EnumBizBool defaultFlag) {
            this.instance.setDefaultFlag(defaultFlag);
            return this;
        }

        public Builder addCreateDate(Date createDate) {
            this.instance.setCreateDate(createDate);
            return this;
        }

        public Builder addUpdateDate(Date updateDate) {
            this.instance.setUpdateDate(updateDate);
            return this;
        }

        public UserContactStationBizDto build() {
            return this.instance;
        }
    }

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
        return "UserContactStationBizDto{" + "id=" + id + ", userId=" + userId + ", type=" + type + ", state=" + state
            + ", defaultFlag=" + defaultFlag + ", createDate=" + createDate + ", updateDate=" + updateDate + '}';
    }
}