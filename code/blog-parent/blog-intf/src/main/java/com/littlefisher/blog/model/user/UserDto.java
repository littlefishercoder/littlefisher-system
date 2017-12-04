package com.littlefisher.blog.model.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.littlefisher.blog.enums.user.EnumUserState;

/**
 * Description: user 实体
 *
 * Created on 2017年11月24日
 *
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
    @ApiModelProperty(value = "主键")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 账号
     */
    @ApiModelProperty(value = "账号")
    @Column(name = "acc_nbr")
    private String accNbr;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 中文真实姓名
     */
    @ApiModelProperty(value = "中文真实姓名")
    @Column(name = "real_name")
    private String realName;

    /**
     * 中文昵称
     */
    @ApiModelProperty(value = "中文昵称")
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 英文名称
     */
    @ApiModelProperty(value = "英文名称")
    @Column(name = "en_name")
    private String enName;

    /**
     * QQ
     */
    @ApiModelProperty(value = "QQ")
    private String qq;

    /**
     * 微信
     */
    @ApiModelProperty(value = "微信")
    private String wechat;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    @Column(name = "phone_nbr")
    private String phoneNbr;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    @Column(name = "user_desc")
    private String userDesc;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private EnumUserState state;

    /**
     * 注册时间
     */
    @ApiModelProperty(value = "注册时间")
    @Column(name = "reg_date")
    private Date regDate;

    /**
     * 最后一次登录时间
     */
    @ApiModelProperty(value = "最后一次登录时间")
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
        return "UserDto{" + "id=" + id + ", accNbr='" + accNbr + '\'' + ", password='" + password + '\'' + ", email='"
               + email + '\'' + ", realName='" + realName + '\'' + ", nickName='" + nickName + '\'' + ", enName='"
               + enName + '\'' + ", qq='" + qq + '\'' + ", wechat='" + wechat + '\'' + ", phoneNbr='" + phoneNbr + '\''
               + ", userDesc='" + userDesc + '\'' + ", state='" + state + '\'' + ", regDate=" + regDate
               + ", lastLoginDate=" + lastLoginDate + '}';
    }
}