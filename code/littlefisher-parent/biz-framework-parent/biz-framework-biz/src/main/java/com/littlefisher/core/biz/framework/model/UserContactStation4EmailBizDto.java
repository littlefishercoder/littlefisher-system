package com.littlefisher.core.biz.framework.model;

import java.io.Serializable;
import java.util.Date;

import com.littlefisher.biz.framework.common.enums.EnumUserContactStation4EmailType;

/**
 *
 * Description: bfm_user_contact_station_4_email 实体
 *
 * Created on 2018年01月10日
 * 
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class UserContactStation4EmailBizDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 8258905815948749629L;

    /**
     * 主键
     */
    private Long contactStationId;

    /**
     * 邮箱类型
     */
    private EnumUserContactStation4EmailType type;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date updateDate;

    public static class Builder {

        private UserContactStation4EmailBizDto instance = new UserContactStation4EmailBizDto();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addContactStationId(Long contactStationId) {
            this.instance.setContactStationId(contactStationId);
            return this;
        }

        public Builder addType(EnumUserContactStation4EmailType type) {
            this.instance.setType(type);
            return this;
        }

        public Builder addEmail(String email) {
            this.instance.setEmail(email);
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

        public UserContactStation4EmailBizDto build() {
            return this.instance;
        }
    }

    public Long getContactStationId() {
        return contactStationId;
    }

    public void setContactStationId(Long contactStationId) {
        this.contactStationId = contactStationId;
    }

    public EnumUserContactStation4EmailType getType() {
        return type;
    }

    public void setType(EnumUserContactStation4EmailType type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "UserContactStation4EmailBizDto{" + "contactStationId=" + contactStationId + ", type=" + type
            + ", email='" + email + '\'' + ", createDate=" + createDate + ", updateDate=" + updateDate + '}';
    }
}