package com.littlefisher.user.request;

import java.io.Serializable;
import java.util.Date;

import com.littlefisher.user.common.enums.EnumUserState;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

/**
 * Description: UpdateUserRequest.java
 *
 * Created on 2018年02月05日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("修改用户请求")
public class UpdateUserRequest implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -6723172511098425650L;

    /**
     * 主键
     */
    @ApiModelProperty(required = true, value = "主键")
    @NotNull(message = "用户主键不能为空")
    @NotBlank(message = "用户主键不能为空")
    private Long id;

    /**
     * 账号
     */
    @ApiModelProperty("账号")
    private String accNbr;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 中文真实姓名
     */
    @ApiModelProperty("中文真实姓名")
    private String realName;

    /**
     * 中文昵称
     */
    @ApiModelProperty("中文昵称")
    private String nickName;

    /**
     * 英文名称
     */
    @ApiModelProperty("英文名称")
    private String enName;

    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String userDesc;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private EnumUserState state;

    /**
     * 最后一次登录时间
     */
    @ApiModelProperty("最后一次登录时间")
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

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    @Override
    public String toString() {
        return "UpdateUserRequest{" + "id=" + id + ", accNbr='" + accNbr + '\'' + ", password='" + password + '\''
            + ", realName='" + realName + '\'' + ", nickName='" + nickName + '\'' + ", enName='" + enName + '\''
            + ", userDesc='" + userDesc + '\'' + ", state=" + state + ", lastLoginDate=" + lastLoginDate + '}';
    }
}
