package com.littlefisher.blog.user.model.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 
 * Description: 
 *  
 * Created on 2017年5月18日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel(value = "查询User列表的入参条件，分页用")
public class GetUserList4PagerByCondRequest {

    /**
     * pageNum 页码
     */
    @ApiModelProperty(value = "页码")
    private int pageNum;
    
    /**
     * pageSize 每页行数
     */
    @ApiModelProperty(value = "每页行数")
    private int pageSize;
    
    /**
     * accNbr 账号
     */
    @ApiModelProperty(value = "账号")
    private String accNbr;
    
    /**
     * email 邮箱，模糊查询
     */
    @ApiModelProperty(value = "邮箱，模糊查询")
    private String email;
    
    /**
     * realName 真实姓名，模糊查询
     */
    @ApiModelProperty(value = "真实姓名，模糊查询")
    private String realName;
    
    /**
     * nickName 昵称，模糊查询
     */
    @ApiModelProperty(value = "昵称，模糊查询")
    private String nickName;
    
    /**
     * eName 英文名，模糊查询
     */
    @ApiModelProperty(value = "英文名，模糊查询")
    private String enName;
    
    /**
     * qq qq,模糊查询
     */
    @ApiModelProperty(value = "qq,模糊查询")
    private String qq;
    
    /**
     * phoneNbr 手机号，模糊查询
     */
    @ApiModelProperty(value = "手机号，模糊查询")
    private String phoneNbr;
    
    /**
     * state 状态
     */
    @ApiModelProperty(value = "状态")
    private String state;
    
    /**
     * regDateStart 注册时间，时间范围 开始
     */
    @ApiModelProperty(value = "注册时间，时间范围 开始")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date regDateStart;
    
    /**
     * regDateEnd 注册时间，时间范围 截止
     */
    @ApiModelProperty(value = "注册时间，时间范围 截止")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
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
