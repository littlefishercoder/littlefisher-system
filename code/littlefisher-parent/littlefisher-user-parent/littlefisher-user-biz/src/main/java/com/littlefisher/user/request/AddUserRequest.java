package com.littlefisher.user.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.sf.oval.constraint.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Description: AddUserRequest.java
 *
 * Created on 2018年02月05日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("新增用户请求")
public class AddUserRequest implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1833395244819612149L;

    /**
     * 账号
     */
    @ApiModelProperty(required = true, value = "账号")
    @NotNull(message = "账号不能为空")
    @NotBlank(message = "账号不能为空")
    private String accNbr;

    /**
     * 密码
     */
    @ApiModelProperty(required = true, value = "密码")
    @NotNull(message = "密码不能为空")
    @NotBlank(message = "密码不能为空")
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

    @Override
    public String toString() {
        return "AddUserRequest{" + "accNbr='" + accNbr + '\'' + ", password='" + password + '\'' + ", realName='" +
                realName + '\'' + ", nickName='" + nickName + '\'' + ", enName='" + enName + '\'' + ", userDesc='" +
                userDesc + '\'' + '}';
    }
}
