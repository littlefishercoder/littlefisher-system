package com.littlefisher.user.biz.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

/**
 *
 * @author jinyn22648
 * @version $$Id: LoginRequest.java, v 0.1 2018/7/12 下午2:20 jinyn22648 Exp $$
 */
@ApiModel("用户登录请求")
public class LoginRequest implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -899266994056433927L;

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

    @Override
    public String toString() {
        return "LoginRequest{" + "accNbr='" + accNbr + '\'' + ", password='" + password + '\'' + '}';
    }
}
