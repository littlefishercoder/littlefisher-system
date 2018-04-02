package com.littlefisher.user.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import com.littlefisher.user.common.enums.EnumUserState;
import com.littlefisher.core.mybatis.pagehelper.PageParam;

/**
 * Description:
 *
 * Created on 2017年5月18日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("查询User列表的入参条件，分页用")
public class GetUserList4PageByCondRequest extends PageParam {

    /** serialVersionUID */
    private static final long serialVersionUID = 1995732920194320377L;

    /**
     * accNbr 账号
     */
    @ApiModelProperty("账号")
    private String accNbr;

    /**
     * realName 真实姓名，模糊查询
     */
    @ApiModelProperty("真实姓名，模糊查询")
    private String realName;

    /**
     * nickName 昵称，模糊查询
     */
    @ApiModelProperty("昵称，模糊查询")
    private String nickName;

    /**
     * eName 英文名，模糊查询
     */
    @ApiModelProperty("英文名，模糊查询")
    private String enName;

    /**
     * state 状态
     */
    @ApiModelProperty("状态")
    private EnumUserState state;

    /**
     * regDateStart 注册时间，时间范围 开始
     */
    @ApiModelProperty("注册时间，时间范围 开始")
    private Date regDateStart;

    /**
     * regDateEnd 注册时间，时间范围 截止
     */
    @ApiModelProperty("注册时间，时间范围 截止")
    private Date regDateEnd;

    public String getAccNbr() {
        return accNbr;
    }

    public void setAccNbr(String accNbr) {
        this.accNbr = accNbr;
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

    public EnumUserState getState() {
        return state;
    }

    public void setState(EnumUserState state) {
        this.state = state;
    }

    public Date getRegDateStart() {
        return regDateStart;
    }

    public void setRegDateStart(Date regDateStart) {
        this.regDateStart = regDateStart;
    }

    public Date getRegDateEnd() {
        return regDateEnd;
    }

    public void setRegDateEnd(Date regDateEnd) {
        this.regDateEnd = regDateEnd;
    }

    @Override
    public String toString() {
        return "GetUserList4PageByCondRequest{" + "accNbr='" + accNbr + '\'' + ", realName='" + realName + '\'' +
                ", nickName='" + nickName + '\'' + ", enName='" + enName + '\'' + ", state=" + state +
                ", regDateStart=" + regDateStart + ", regDateEnd=" + regDateEnd + "} " + super.toString();
    }
}
