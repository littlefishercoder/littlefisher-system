package com.littlefisher.blog.biz.model;

import java.io.Serializable;
import java.util.Date;

import com.littlefisher.blog.common.enums.EnumCommentaryState;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author jinyn22648
 * @version $$Id: CommentaryBizDto.java, v 0.1 2018/3/23 下午12:35 jinyn22648 Exp $$
 */
@ApiModel("评价信息")
public class CommentaryBizDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -2357367209794103488L;

    /**
     * id
     */
    @ApiModelProperty("id")
    private Long id;

    /**
     * 父评价主键
     */
    @ApiModelProperty("父评价主键")
    private Long parentCommentaryId;

    /**
     * 评价人主键和昵称二选一，评价人主键为空说明是匿名评价，则必须有昵称来展示
     */
    @ApiModelProperty("评价人主键和昵称二选一，评价人主键为空说明是匿名评价，则必须有昵称来展示")
    private Long userId;

    /**
     * 评价人主键和昵称二选一，评价人主键为空说明是匿名评价，则必须有昵称来展示
     */
    @ApiModelProperty("评价人主键和昵称二选一，评价人主键为空说明是匿名评价，则必须有昵称来展示")
    private String nickName;

    /**
     * ip地址
     */
    @ApiModelProperty("ip地址")
    private String commentaryIp;

    /**
     * 评价时间
     */
    @ApiModelProperty("评价时间")
    private Date createdDate;

    /**
     * 博文主键
     */
    @ApiModelProperty("评价时间")
    private Long postId;

    /**
     * 状态
     */
    @ApiModelProperty("评价时间")
    private EnumCommentaryState state;

    /**
     * 状态变更时间
     */
    @ApiModelProperty("评价时间")
    private Date stateDate;

    /**
     * 修改时间
     */
    @ApiModelProperty("评价时间")
    private Date updateDate;

    /**
     * 评论内容
     */
    @ApiModelProperty("评价时间")
    private String content;

    public static final class Builder {

        private CommentaryBizDto instance = new CommentaryBizDto();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addId(Long id) {
            this.instance.setId(id);
            return this;
        }

        public Builder addParentCommentaryId(Long parentCommentaryId) {
            this.instance.setParentCommentaryId(parentCommentaryId);
            return this;
        }

        public Builder addUserId(Long userId) {
            this.instance.setUserId(userId);
            return this;
        }

        public Builder addNickName(String nickName) {
            this.instance.setNickName(nickName);
            return this;
        }

        public Builder addCommentaryIp(String commentaryIp) {
            this.instance.setCommentaryIp(commentaryIp);
            return this;
        }

        public Builder addCreatedDate(Date createdDate) {
            this.instance.setCreatedDate(createdDate);
            return this;
        }

        public Builder addPostId(Long postId) {
            this.instance.setPostId(postId);
            return this;
        }

        public Builder addState(EnumCommentaryState state) {
            this.instance.setState(state);
            return this;
        }

        public Builder addStateDate(Date stateDate) {
            this.instance.setStateDate(stateDate);
            return this;
        }

        public Builder addUpdateDate(Date updateDate) {
            this.instance.setUpdateDate(updateDate);
            return this;
        }

        public Builder addContent(String content) {
            this.instance.setContent(content);
            return this;
        }

        public CommentaryBizDto build() {
            return this.instance;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentCommentaryId() {
        return parentCommentaryId;
    }

    public void setParentCommentaryId(Long parentCommentaryId) {
        this.parentCommentaryId = parentCommentaryId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCommentaryIp() {
        return commentaryIp;
    }

    public void setCommentaryIp(String commentaryIp) {
        this.commentaryIp = commentaryIp;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public EnumCommentaryState getState() {
        return state;
    }

    public void setState(EnumCommentaryState state) {
        this.state = state;
    }

    public Date getStateDate() {
        return stateDate;
    }

    public void setStateDate(Date stateDate) {
        this.stateDate = stateDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommentaryBizDto{" + "id=" + id + ", parentCommentaryId=" + parentCommentaryId + ", userId=" + userId
            + ", nickName='" + nickName + '\'' + ", commentaryIp='" + commentaryIp + '\'' + ", createdDate="
            + createdDate + ", postId=" + postId + ", state=" + state + ", stateDate=" + stateDate + ", updateDate="
            + updateDate + ", content='" + content + '\'' + '}';
    }
}
