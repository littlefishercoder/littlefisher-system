package com.littlefisher.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import com.littlefisher.user.common.enums.EnumUserContactStation4WebsiteType;

/**
 *
 * Description: bfm_user_contact_station_4_website 实体
 *
 * Created on 2018年01月10日
 * 
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("网站联系点")
public class UserContactStation4WebsiteBizDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1311919885608667738L;

    /**
     * 联系点主键
     */
    @ApiModelProperty("联系点主键")
    private Long contactStationId;

    /**
     * 类型
     */
    @ApiModelProperty("类型")
    private EnumUserContactStation4WebsiteType type;

    /**
     * 网址
     */
    @ApiModelProperty("网址")
    private String website;

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

        private UserContactStation4WebsiteBizDto instance = new UserContactStation4WebsiteBizDto();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
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

        public UserContactStation4WebsiteBizDto build() {
            return this.instance;
        }
    }

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
        return "UserContactStation4WebsiteBizDto{" + "contactStationId=" + contactStationId + ", type=" + type
            + ", website='" + website + '\'' + ", createDate=" + createDate + ", updateDate=" + updateDate + '}';
    }
}