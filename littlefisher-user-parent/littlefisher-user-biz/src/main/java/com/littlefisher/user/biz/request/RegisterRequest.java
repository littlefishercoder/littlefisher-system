package com.littlefisher.user.biz.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

/**
 *
 * @author jinyn22648
 * @version $$Id: RegisterRequest.java, v 0.1 2018/7/12 下午2:27 jinyn22648 Exp $$
 */
@ApiModel("注册信息")
public class RegisterRequest implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -8276216320183979718L;

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
        return "RegisterRequest{" + "accNbr='" + accNbr + '\'' + ", password='" + password + '\'' + ", realName='"
            + realName + '\'' + ", nickName='" + nickName + '\'' + ", enName='" + enName + '\'' + ", userDesc='"
            + userDesc + '\'' + '}';
    }
}
