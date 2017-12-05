package com.littlefisher.blog.model.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.littlefisher.blog.enums.user.EnumUserState;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 *
 * Description: user 实体
 *
 * Created on 2017年12月05日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "user")
@ApiModel("user实体")
public class UserDto implements Serializable {
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
     * 账号
     */
    @ApiModelProperty("账号")
    @Column(name = "acc_nbr")
    private String accNbr;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 中文真实姓名
     */
    @ApiModelProperty("中文真实姓名")
    @Column(name = "real_name")
    private String realName;

    /**
     * 中文昵称
     */
    @ApiModelProperty("中文昵称")
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 英文名称
     */
    @ApiModelProperty("英文名称")
    @Column(name = "en_name")
    private String enName;

    /**
     * QQ
     */
    @ApiModelProperty("QQ")
    private String qq;

    /**
     * 微信
     */
    @ApiModelProperty("微信")
    private String wechat;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    @Column(name = "phone_nbr")
    private String phoneNbr;

    /**
     * 描述
     */
    @ApiModelProperty("描述")
    @Column(name = "user_desc")
    private String userDesc;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private EnumUserState state;

    /**
     * 注册时间
     */
    @ApiModelProperty("注册时间")
    @Column(name = "reg_date")
    private Date regDate;

    /**
     * 最后一次登录时间
     */
    @ApiModelProperty("最后一次登录时间")
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getPhoneNbr() {
        return phoneNbr;
    }

    public void setPhoneNbr(String phoneNbr) {
        this.phoneNbr = phoneNbr;
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
        sb.append(", email=").append(email);
        sb.append(", realName=").append(realName);
        sb.append(", nickName=").append(nickName);
        sb.append(", enName=").append(enName);
        sb.append(", qq=").append(qq);
        sb.append(", wechat=").append(wechat);
        sb.append(", phoneNbr=").append(phoneNbr);
        sb.append(", userDesc=").append(userDesc);
        sb.append(", state=").append(state);
        sb.append(", regDate=").append(regDate);
        sb.append(", lastLoginDate=").append(lastLoginDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}