package com.littlefisher.core.biz.framework.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import com.littlefisher.core.biz.framework.enums.EnumUserState;

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
public class GetUserList4PagerByCondRequest {

    /**
     * pageNum 页码
     */
    @ApiModelProperty("页码")
    private int pageNum;

    /**
     * pageSize 每页行数
     */
    @ApiModelProperty("每页行数")
    private int pageSize;

    /**
     * accNbr 账号
     */
    @ApiModelProperty("账号")
    private String accNbr;

    /**
     * email 邮箱，模糊查询
     */
    @ApiModelProperty("邮箱，模糊查询")
    private String email;

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
     * qq qq,模糊查询
     */
    @ApiModelProperty("qq,模糊查询")
    private String qq;

    /**
     * phoneNbr 手机号，模糊查询
     */
    @ApiModelProperty("手机号，模糊查询")
    private String phoneNbr;

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

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getAccNbr() {
        return accNbr;
    }

    public void setAccNbr(String accNbr) {
        this.accNbr = accNbr;
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

    public String getPhoneNbr() {
        return phoneNbr;
    }

    public void setPhoneNbr(String phoneNbr) {
        this.phoneNbr = phoneNbr;
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
        StringBuilder builder = new StringBuilder();
        builder.append("GetUserList4PagerByCondRequest [pageNum=");
        builder.append(pageNum);
        builder.append(", pageSize=");
        builder.append(pageSize);
        builder.append(", accNbr=");
        builder.append(accNbr);
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
        builder.append(", phoneNbr=");
        builder.append(phoneNbr);
        builder.append(", state=");
        builder.append(state);
        builder.append(", regDateStart=");
        builder.append(regDateStart);
        builder.append(", regDateEnd=");
        builder.append(regDateEnd);
        builder.append("]");
        return builder.toString();
    }

}
