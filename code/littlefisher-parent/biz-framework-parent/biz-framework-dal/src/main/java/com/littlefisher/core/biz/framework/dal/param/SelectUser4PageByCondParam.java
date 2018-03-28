package com.littlefisher.core.biz.framework.dal.param;

import java.io.Serializable;
import java.util.Date;

import com.littlefisher.biz.framework.common.enums.EnumUserState;

/**
 *
 * @author jinyn22648
 * @version $$Id: SelectUser4PageByCondParam.java, v 0.1 2018/3/26 下午8:09 jinyn22648 Exp $$
 */
public class SelectUser4PageByCondParam implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 3971264669088597906L;

    /**
     * accNbr 账号
     */
    private String accNbr;

    /**
     * realName 真实姓名，模糊查询
     */
    private String realName;

    /**
     * nickName 昵称，模糊查询
     */
    private String nickName;

    /**
     * eName 英文名，模糊查询
     */
    private String enName;

    /**
     * state 状态
     */
    private EnumUserState state;

    /**
     * regDateStart 注册时间，时间范围 开始
     */
    private Date regDateStart;

    /**
     * regDateEnd 注册时间，时间范围 截止
     */
    private Date regDateEnd;

    public static class Builder {

        private SelectUser4PageByCondParam instance = new SelectUser4PageByCondParam();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addAccNbr(String accNbr) {
            this.instance.setAccNbr(accNbr);
            return this;
        }

        public Builder addRealName(String realName) {
            this.instance.setRealName(realName);
            return this;
        }

        public Builder addNickName(String nickName) {
            this.instance.setNickName(nickName);
            return this;
        }

        public Builder addEnName(String enName) {
            this.instance.setEnName(enName);
            return this;
        }

        public Builder addState(EnumUserState state) {
            this.instance.setState(state);
            return this;
        }

        public Builder addRegDateStart(Date regDateStart) {
            this.instance.setRegDateStart(regDateStart);
            return this;
        }

        public Builder addRegDateEnd(Date regDateEnd) {
            this.instance.setRegDateEnd(regDateEnd);
            return this;
        }

        public SelectUser4PageByCondParam build() {
            return this.instance;
        }
    }

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
        return "SelectUser4PageByCondParam{" + "accNbr='" + accNbr + '\'' + ", realName='" + realName + '\''
            + ", nickName='" + nickName + '\'' + ", enName='" + enName + '\'' + ", state=" + state + ", regDateStart="
            + regDateStart + ", regDateEnd=" + regDateEnd + '}';
    }
}
