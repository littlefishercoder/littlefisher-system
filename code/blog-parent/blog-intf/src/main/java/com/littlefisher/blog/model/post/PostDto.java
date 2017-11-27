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

import com.littlefisher.blog.model.user.UserDto;

/**
 *
 * Description: post 实体
 *
 * Created on 2017年11月24日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "post")
@ApiModel("post实体")
public class PostDto implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 标题
     */
    @ApiModelProperty("标题")
    private String title;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @Column(name = "created_date")
    private Date createdDate;

    /**
     * 原文链接
     */
    @ApiModelProperty("原文链接")
    @Column(name = "original_url")
    private String originalUrl;

    /**
     * 类型
     */
    @ApiModelProperty("类型")
    private String type;

    /**
     * 上次修改时间
     */
    @ApiModelProperty("上次修改时间")
    @Column(name = "last_modify_date")
    private Date lastModifyDate;

    /**
     * 阅读数
     */
    @ApiModelProperty("阅读数")
    @Column(name = "read_times")
    private Long readTimes;

    /**
     * 点赞数
     */
    @ApiModelProperty("点赞数")
    @Column(name = "liked_times")
    private Long likedTimes;

    /**
     * 评论数
     */
    @ApiModelProperty("评论数")
    @Column(name = "comment_times")
    private Long commentTimes;

    /**
     * 作者主键，空为匿名作者
     */
    @ApiModelProperty("作者主键，空为匿名作者")
    @Column(name = "user_id")
    private Long userId;

    /**
     * 是否可评论，Y为可评论， 空或N为不可评论
     */
    @ApiModelProperty("是否可评论，Y为可评论， 空或N为不可评论")
    @Column(name = "enable_comment")
    private String enableComment;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private String state;

    /**
     * 状态变更时间
     */
    @ApiModelProperty("状态变更时间")
    @Column(name = "state_date")
    private Date stateDate;

    /**
     * 博文
     */
    @ApiModelProperty("博文")
    private String content;

    /**
     * 作者
     */
    @ApiModelProperty("作者")
    private UserDto author;

    /**
     * 博文状态
     */
    @ApiModelProperty("博文状态")
    private PostStateDto postState;

    /**
     * 博文类型
     */
    @ApiModelProperty("博文类型")
    private PostTypeDto postType;

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

    public UserDto getAuthor() {
        return author;
    }

    public void setAuthor(UserDto author) {
        this.author = author;
    }

    public PostStateDto getPostState() {
        return postState;
    }

    public void setPostState(PostStateDto postState) {
        this.postState = postState;
    }

    public PostTypeDto getPostType() {
        return postType;
    }

    public void setPostType(PostTypeDto postType) {
        this.postType = postType;
    }

    @Override
    public String toString() {
        return "PostDto{" + "id=" + id + ", title='" + title + '\'' + ", createdDate=" + createdDate + ", originalUrl='"
               + originalUrl + '\'' + ", type='" + type + '\'' + ", lastModifyDate=" + lastModifyDate + ", readTimes="
               + readTimes + ", likedTimes=" + likedTimes + ", commentTimes=" + commentTimes + ", userId=" + userId
               + ", enableComment='" + enableComment + '\'' + ", state='" + state + '\'' + ", stateDate=" + stateDate
               + ", content='" + content + '\'' + ", author=" + author + ", postState=" + postState + ", postType="
               + postType + '}';
    }
}