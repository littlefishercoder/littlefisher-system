package com.littlefisher.user.dal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.littlefisher.user.common.enums.EnumUserContactStation4WebsiteType;


/**
 *
 * Description: bfm_user_contact_station_4_website 实体
 *
 * Created on 2018年03月30日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "bfm_user_contact_station_4_website")
public class UserContactStation4WebsiteDto implements Serializable {
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
    private EnumUserContactStation4WebsiteType type;

    /**
     * 网址
     */
    private String website;

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

    public EnumUserContactStation4WebsiteType getType() {
        return type;
    }

    public void setType(EnumUserContactStation4WebsiteType type) {
        this.type = type;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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
        sb.append(", website=").append(website);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static class Builder {
        private UserContactStation4WebsiteDto instance;

        private Builder() {
            super();
        }

        public static Builder getInstance() {
            Builder builder = new Builder();
            builder.instance = new UserContactStation4WebsiteDto();
            return builder;
        }

        public static Builder getInstance(UserContactStation4WebsiteDto instance) {
            Builder builder = new Builder();
            builder.instance = instance;
            return builder;
        }

        public Builder addContactStationId(Long contactStationId) {
            this.instance.setContactStationId(contactStationId);
            return this;
        }

        public Builder addType(EnumUserContactStation4WebsiteType type) {
            this.instance.setType(type);
            return this;
        }

        public Builder addWebsite(String website) {
            this.instance.setWebsite(website);
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

        public UserContactStation4WebsiteDto build() {
            return this.instance;
        }
    }
}