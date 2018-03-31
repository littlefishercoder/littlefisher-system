package com.littlefisher.blog.biz.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import com.littlefisher.blog.common.enums.EnumPostState;
import com.littlefisher.blog.common.enums.EnumPostType;
import com.littlefisher.core.stereotype.enums.EnumBizBool;

/**
 *
 * @author jinyn22648
 * @version $$Id: PostBizDto.java, v 0.1 2018/3/23 下午12:37 jinyn22648 Exp $$
 */
@ApiModel("博文")
public class PostBizDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -2256226072522050494L;

    /**
     * id
     */
    @ApiModelProperty("id")
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
    private Date createdDate;

    /**
     * 原文链接
     */
    @ApiModelProperty("原文链接")
    private String originalUrl;

    /**
     * 类型
     */
    @ApiModelProperty("类型")
    private EnumPostType type;

    /**
     * 文章分类 主键
     */
    @ApiModelProperty("文章分类 主键")
    private Long archiveId;

    /**
     * 作者主键
     */
    @ApiModelProperty("作者主键")
    private Long authorId;

    /**
     * 是否可评论
     */
    @ApiModelProperty("是否可评论")
    private EnumBizBool enableComment;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private EnumPostState state;

    /**
     * 状态变更时间
     */
    @ApiModelProperty("状态变更时间")
    private Date stateDate;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date updateDate;

    /**
     * 博文
     */
    @ApiModelProperty("博文")
    private String content;

    public static class Builder {

        private PostBizDto instance = new PostBizDto();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addId(Long id) {
            this.instance.setId(id);
            return this;
        }

        public Builder addTitle(String title) {
            this.instance.setTitle(title);
            return this;
        }

        public Builder addCreatedDate(Date createdDate) {
            this.instance.setCreatedDate(createdDate);
            return this;
        }

        public Builder addOriginalUrl(String originalUrl) {
            this.instance.setOriginalUrl(originalUrl);
            return this;
        }

        public Builder addType(EnumPostType type) {
            this.instance.setType(type);
            return this;
        }

        public Builder addArchiveId(Long archiveId) {
            this.instance.setArchiveId(archiveId);
            return this;
        }

        public Builder addAuthorId(Long authorId) {
            this.instance.setAuthorId(authorId);
            return this;
        }

        public Builder addEnableComment(EnumBizBool enableComment) {
            this.instance.setEnableComment(enableComment);
            return this;
        }

        public Builder addState(EnumPostState state) {
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

        public PostBizDto build() {
            return this.instance;
        }
    }

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

    public Long getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Long archiveId) {
        this.archiveId = archiveId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public EnumBizBool getEnableComment() {
        return enableComment;
    }

    public void setEnableComment(EnumBizBool enableComment) {
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
        return "PostBizDto{" + "id=" + id + ", title='" + title + '\'' + ", createdDate=" + createdDate
            + ", originalUrl='" + originalUrl + '\'' + ", type=" + type + ", archiveId=" + archiveId + ", authorId="
            + authorId + ", enableComment=" + enableComment + ", state=" + state + ", stateDate=" + stateDate
            + ", updateDate=" + updateDate + ", content='" + content + '\'' + '}';
    }
}
