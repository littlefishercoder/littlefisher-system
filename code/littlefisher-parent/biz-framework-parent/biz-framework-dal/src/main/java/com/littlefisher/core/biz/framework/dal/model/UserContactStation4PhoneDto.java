package com.littlefisher.core.biz.framework.dal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.littlefisher.biz.framework.common.enums.EnumUserContactStation4PhoneType;


/**
 *
 * Description: bfm_user_contact_station_4_phone 实体
 *
 * Created on 2018年03月30日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "bfm_user_contact_station_4_phone")
public class UserContactStation4PhoneDto implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 联系点主键
     */
    @Id
    @Column(name = "contact_station_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long contactStationId;

    /**
     * 类型
     */
    private EnumUserContactStation4PhoneType type;

    /**
     * 区号
     */
    @Column(name = "area_code")
    private String areaCode;

    /**
     * 手机号
     */
    @Column(name = "phone_nbr")
    private String phoneNbr;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 修改时间
     */
    @Column(name = "update_date")
    private Date updateDate;

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
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", contactStationId=").append(contactStationId);
        sb.append(", type=").append(type);
        sb.append(", areaCode=").append(areaCode);
        sb.append(", phoneNbr=").append(phoneNbr);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static class Builder {
        private UserContactStation4PhoneDto instance;

        private Builder() {
            super();
        }

        public static Builder getInstance() {
            Builder builder = new Builder();
            builder.instance = new UserContactStation4PhoneDto();
            return builder;
        }

        public static Builder getInstance(UserContactStation4PhoneDto instance) {
            Builder builder = new Builder();
            builder.instance = instance;
            return builder;
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

        public UserContactStation4PhoneDto build() {
            return this.instance;
        }
    }
}