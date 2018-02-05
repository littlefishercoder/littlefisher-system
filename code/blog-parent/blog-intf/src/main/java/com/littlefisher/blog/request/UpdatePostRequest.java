package com.littlefisher.blog.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.sf.oval.constraint.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

import com.littlefisher.blog.enums.EnumPostState;
import com.littlefisher.blog.enums.EnumPostType;
import com.littlefisher.core.stereotype.enums.EnumBizBool;

/**
 * Description: UpdatePostRequest.java
 *
 * Created on 2018年02月05日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("修改博文请求")
public class UpdatePostRequest implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 4189667527520662890L;

    /** id */
    @ApiModelProperty(required = true, value = "id")
    @NotNull(message = "博文主键不能为空")
    @NotBlank(message = "博文主键不能为空")
    private Long id;

    /**
     * 标题
     */
    @ApiModelProperty("标题")
    private String title;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "UpdatePostRequest{" + "id=" + id + ", title='" + title + '\'' + ", originalUrl='" + originalUrl + '\'' +
                ", type=" + type + ", archiveId=" + archiveId + ", enableComment=" + enableComment + ", state=" +
                state + ", content='" + content + '\'' + '}';
    }
}
