package com.littlefisher.blog.biz.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import com.littlefisher.blog.common.enums.EnumAuthorState;

/**
 * Description: AuthorBizDto
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("作者信息")
public class AuthorBizDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 8285991827710244236L;

    /**
     * 主键，跟bfm_user表相同主键
     */
    @ApiModelProperty("")
    private Long id;

    /**
     * 笔名
     */
    @ApiModelProperty("")
    private String penName;

    /**
     * 座右铭
     */
    @ApiModelProperty("")
    private String motto;

    /**
     * 状态
     */
    @ApiModelProperty("")
    private EnumAuthorState state;

    /**
     * 修改时间
     */
    @ApiModelProperty("")
    private Date updateDate;

    public static class Builder {

        private AuthorBizDto instance = new AuthorBizDto();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addId(Long id) {
            this.instance.setId(id);
            return this;
        }

        public Builder addPenName(String penName) {
            this.instance.setPenName(penName);
            return this;
        }

        public Builder addMotto(String motto) {
            this.instance.setMotto(motto);
            return this;
        }

        public Builder addState(EnumAuthorState state) {
            this.instance.setState(state);
            return this;
        }

        public Builder addUpdateDate(Date updateDate) {
            this.instance.setUpdateDate(updateDate);
            return this;
        }

        public AuthorBizDto build() {
            return this.instance;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPenName() {
        return penName;
    }

    public void setPenName(String penName) {
        this.penName = penName;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public EnumAuthorState getState() {
        return state;
    }

    public void setState(EnumAuthorState state) {
        this.state = state;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "AuthorBizDto{" + "id=" + id + ", penName='" + penName + '\'' + ", motto='" + motto + '\'' + ", state="
            + state + ", updateDate=" + updateDate + '}';
    }
}
