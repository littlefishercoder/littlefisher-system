package com.littlefisher.core.biz.framework.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import com.littlefisher.biz.framework.common.enums.EnumUserContactStation4PhoneType;

/**
 *
 * Description: bfm_user_contact_station_4_phone 实体
 *
 * Created on 2018年01月10日
 * 
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("电话联系点")
public class UserContactStation4PhoneBizDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -3331885492140266445L;

    /**
     * 联系点主键
     */
    @ApiModelProperty("联系点主键")
    private Long contactStationId;

    /**
     * 类型
     */
    @ApiModelProperty("类型")
    private EnumUserContactStation4PhoneType type;

    /**
     * 区号
     */
    @ApiModelProperty("区号")
    private String areaCode;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phoneNbr;

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

        private UserContactStation4PhoneBizDto instance = new UserContactStation4PhoneBizDto();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addContactStationId(Long contactStationId) {
            this.instance.setContactStationId(contactStationId);
            return this;
        }

        public Builder addType(EnumUserContactStation4PhoneType type) {
            this.instance.setType(type);
            return this;
        }

        public Builder addAreaCode(String areaCode) {
            this.instance.setAreaCode(areaCode);
            return this;
        }

        public Builder addPhoneNbr(String phoneNbr) {
            this.instance.setPhoneNbr(phoneNbr);
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

        public UserContactStation4PhoneBizDto build() {
            return this.instance;
        }
    }

    public Long getContactStationId() {
        return contactStationId;
    }

    public void setContactStationId(Long contactStationId) {
        this.contactStationId = contactStationId;
    }

    public EnumUserContactStation4PhoneType getType() {
        return type;
    }

    public void setType(EnumUserContactStation4PhoneType type) {
        this.type = type;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPhoneNbr() {
        return phoneNbr;
    }

    public void setPhoneNbr(String phoneNbr) {
        this.phoneNbr = phoneNbr;
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
        return "UserContactStation4PhoneBizDto{" + "contactStationId=" + contactStationId + ", type=" + type
            + ", areaCode='" + areaCode + '\'' + ", phoneNbr='" + phoneNbr + '\'' + ", createDate=" + createDate
            + ", updateDate=" + updateDate + '}';
    }
}