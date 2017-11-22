package com.littlefisher.blog.model.post;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 *
 * Description: post 实体
 *
 * Created on 2017年11月22日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "post")
@ApiModel("post实体")
public class PostDto implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @Column(name = "created_date")
    private Date createdDate;

    /**
     * 原文链接
     */
    @ApiModelProperty(value = "原文链接")
    @Column(name = "original_url")
    private String originalUrl;

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private String type;

    /**
     * 上次修改时间
     */
    @ApiModelProperty(value = "上次修改时间")
    @Column(name = "last_modify_date")
    private Date lastModifyDate;

    /**
     * 阅读数
     */
    @ApiModelProperty(value = "阅读数")
    @Column(name = "read_times")
    private Long readTimes;

    /**
     * 点赞数
     */
    @ApiModelProperty(value = "点赞数")
    @Column(name = "liked_times")
    private Long likedTimes;

    /**
     * 评论数
     */
    @ApiModelProperty(value = "评论数")
    @Column(name = "comment_times")
    private Long commentTimes;

    /**
     * 作者主键，空为匿名作者
     */
    @ApiModelProperty(value = "作者主键，空为匿名作者")
    @Column(name = "user_id")
    private Long userId;

    /**
     * 是否可评论，Y为可评论， 空或N为不可评论
     */
    @ApiModelProperty(value = "是否可评论，Y为可评论， 空或N为不可评论")
    @Column(name = "enable_comment")
    private String enableComment;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String state;

    /**
     * 状态变更时间
     */
    @ApiModelProperty(value = "状态变更时间")
    @Column(name = "state_date")
    private Date stateDate;

    /**
     * 博文
     */
    @ApiModelProperty(value = "博文")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public Long getReadTimes() {
        return readTimes;
    }

    public void setReadTimes(Long readTimes) {
        this.readTimes = readTimes;
    }

    public Long getLikedTimes() {
        return likedTimes;
    }

    public void setLikedTimes(Long likedTimes) {
        this.likedTimes = likedTimes;
    }

    public Long getCommentTimes() {
        return commentTimes;
    }

    public void setCommentTimes(Long commentTimes) {
        this.commentTimes = commentTimes;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEnableComment() {
        return enableComment;
    }

    public void setEnableComment(String enableComment) {
        this.enableComment = enableComment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getStateDate() {
        return stateDate;
    }

    public void setStateDate(Date stateDate) {
        this.stateDate = stateDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", originalUrl=").append(originalUrl);
        sb.append(", type=").append(type);
        sb.append(", lastModifyDate=").append(lastModifyDate);
        sb.append(", readTimes=").append(readTimes);
        sb.append(", likedTimes=").append(likedTimes);
        sb.append(", commentTimes=").append(commentTimes);
        sb.append(", userId=").append(userId);
        sb.append(", enableComment=").append(enableComment);
        sb.append(", state=").append(state);
        sb.append(", stateDate=").append(stateDate);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}