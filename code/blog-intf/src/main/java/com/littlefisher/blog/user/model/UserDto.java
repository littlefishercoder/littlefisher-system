package com.littlefisher.blog.user.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;


/**
 *
 * Description: user 实体
 *
 * Created on 2017年05月22日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "user")
@ApiModel(value = "user实体")
public class UserDto implements Serializable {
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
     * 英文名
     */
    @ApiModelProperty(value = "英文名")
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
    private String state;

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

    /**
     * userState 用户状态
     */
    @ApiModelProperty(value = "用户状态")
    @Transient
    private UserStateDto userState;
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
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

    public UserStateDto getUserState() {
        return userState;
    }

    public void setUserState(UserStateDto userState) {
        this.userState = userState;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserDto [id=");
        builder.append(id);
        builder.append(", accNbr=");
        builder.append(accNbr);
        builder.append(", password=");
        builder.append(password);
        builder.append(", email=");
        builder.append(email);
        builder.append(", realName=");
        builder.append(realName);
        builder.append(", nickName=");
        builder.append(nickName);
        builder.append(", enName=");
        builder.append(enName);
        builder.append(", qq=");
        builder.append(qq);
        builder.append(", wechat=");
        builder.append(wechat);
        builder.append(", phoneNbr=");
        builder.append(phoneNbr);
        builder.append(", userDesc=");
        builder.append(userDesc);
        builder.append(", state=");
        builder.append(state);
        builder.append(", regDate=");
        builder.append(regDate);
        builder.append(", lastLoginDate=");
        builder.append(lastLoginDate);
        builder.append(", userState=");
        builder.append(userState);
        builder.append("]");
        return builder.toString();
    }
}