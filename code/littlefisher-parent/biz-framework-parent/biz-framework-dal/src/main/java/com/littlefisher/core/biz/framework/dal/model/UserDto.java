package com.littlefisher.core.biz.framework.dal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.littlefisher.biz.framework.common.enums.EnumUserState;


/**
 *
 * Description: bfm_user 实体
 *
 * Created on 2018年03月30日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "bfm_user")
public class UserDto implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 账号
     */
    @Column(name = "acc_nbr")
    private String accNbr;

    /**
     * 密码
     */
    private String password;

    /**
     * 中文真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 中文昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 英文名称
     */
    @Column(name = "en_name")
    private String enName;

    /**
     * 描述
     */
    @Column(name = "user_desc")
    private String userDesc;

    /**
     * 状态
     */
    private EnumUserState state;

    /**
     * 注册时间
     */
    @Column(name = "reg_date")
    private Date regDate;

    /**
     * 最后一次登录时间
     */
    @Column(name = "last_login_date")
    private Date lastLoginDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccNbr() {
        return accNbr;
    }

    public void setAccNbr(String accNbr) {
        this.accNbr = accNbr;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public EnumUserState getState() {
        return state;
    }

    public void setState(EnumUserState state) {
        this.state = state;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", accNbr=").append(accNbr);
        sb.append(", password=").append(password);
        sb.append(", realName=").append(realName);
        sb.append(", nickName=").append(nickName);
        sb.append(", enName=").append(enName);
        sb.append(", userDesc=").append(userDesc);
        sb.append(", state=").append(state);
        sb.append(", regDate=").append(regDate);
        sb.append(", lastLoginDate=").append(lastLoginDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static class Builder {
        private UserDto instance;

        private Builder() {
            super();
        }

        public static Builder getInstance() {
            Builder builder = new Builder();
            builder.instance = new UserDto();
            return builder;
        }

        public static Builder getInstance(UserDto instance) {
            Builder builder = new Builder();
            builder.instance = instance;
            return builder;
        }

        public Builder addId(Long id) {
            this.instance.setId(id);
            return this;
        }

        public Builder addAccNbr(String accNbr) {
            this.instance.setAccNbr(accNbr);
            return this;
        }

        public Builder addPassword(String password) {
            this.instance.setPassword(password);
            return this;
        }

        public Builder addRealName(String realName) {
            this.instance.setRealName(realName);
            return this;
        }

        public Builder addNickName(String nickName) {
            this.instance.setNickName(nickName);
            return this;
        }

        public Builder addEnName(String enName) {
            this.instance.setEnName(enName);
            return this;
        }

        public Builder addUserDesc(String userDesc) {
            this.instance.setUserDesc(userDesc);
            return this;
        }

        public Builder addState(EnumUserState state) {
            this.instance.setState(state);
            return this;
        }

        public Builder addRegDate(Date regDate) {
            this.instance.setRegDate(regDate);
            return this;
        }

        public Builder addLastLoginDate(Date lastLoginDate) {
            this.instance.setLastLoginDate(lastLoginDate);
            return this;
        }

        public UserDto build() {
            return this.instance;
        }
    }
}