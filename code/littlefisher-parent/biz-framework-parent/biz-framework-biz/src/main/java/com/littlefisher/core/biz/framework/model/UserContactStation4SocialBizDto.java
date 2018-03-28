package com.littlefisher.core.biz.framework.model;

import java.io.Serializable;
import java.util.Date;

import com.littlefisher.biz.framework.common.enums.EnumUserContactStation4SocialType;

/**
 *
 * Description: bfm_user_contact_station_4_social 实体
 *
 * Created on 2018年01月10日
 * 
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class UserContactStation4SocialBizDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 2172578192190926857L;

    /**
     * 联系点主键
     */
    private Long contactStationId;

    /**
     * 类型
     */
    private EnumUserContactStation4SocialType type;

    /**
     * 账号
     */
    private String account;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date updateDate;

    public static class Builder {

        private UserContactStation4SocialBizDto instance = new UserContactStation4SocialBizDto();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addContactStationId(Long contactStationId) {
            this.instance.setContactStationId(contactStationId);
            return this;
        }

        public Builder addType(EnumUserContactStation4SocialType type) {
            this.instance.setType(type);
            return this;
        }

        public Builder addAccount(String account) {
            this.instance.setAccount(account);
            return this;
        }

        public Builder addNickName(String nickName) {
            this.instance.setNickName(nickName);
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

        public UserContactStation4SocialBizDto build() {
            return this.instance;
        }
    }

    public Long getContactStationId() {
        return contactStationId;
    }

    public void setContactStationId(Long contactStationId) {
        this.contactStationId = contactStationId;
    }

    public EnumUserContactStation4SocialType getType() {
        return type;
    }

    public void setType(EnumUserContactStation4SocialType type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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
        return "UserContactStation4SocialBizDto{" + "contactStationId=" + contactStationId + ", type=" + type
            + ", account='" + account + '\'' + ", nickName='" + nickName + '\'' + ", createDate=" + createDate
            + ", updateDate=" + updateDate + '}';
    }
}