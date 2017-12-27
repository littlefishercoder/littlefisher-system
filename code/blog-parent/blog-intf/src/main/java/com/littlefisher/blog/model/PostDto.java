package com.littlefisher.blog.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.littlefisher.blog.enums.EnumPostState;
import com.littlefisher.blog.enums.EnumPostType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 *
 * Description: post 实体
 *
 * Created on 2017年12月27日
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
    private EnumPostType type;

    /**
     * 上次修改时间
     */
    @ApiModelProperty("上次修改时间")
    @Column(name = "last_modify_date")
    private Date lastModifyDate;

    /**
     * 作者主键，空为匿名作者
     */
    @ApiModelProperty("作者主键，空为匿名作者")
    @Column(name = "author_id")
    private Long authorId;

    /**
     * 是否可评论
     */
    @ApiModelProperty("是否可评论")
    @Column(name = "enable_comment")
    private String enableComment;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private EnumPostState state;

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

    public EnumPostType getType() {
        return type;
    }

    public void setType(EnumPostType type) {
        this.type = type;
    }

    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getEnableComment() {
        return enableComment;
    }

    public void setEnableComment(String enableComment) {
        this.enableComment = enableComment;
    }

    public EnumPostState getState() {
        return state;
    }

    public void setState(EnumPostState state) {
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
        sb.append(", authorId=").append(authorId);
        sb.append(", enableComment=").append(enableComment);
        sb.append(", state=").append(state);
        sb.append(", stateDate=").append(stateDate);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}