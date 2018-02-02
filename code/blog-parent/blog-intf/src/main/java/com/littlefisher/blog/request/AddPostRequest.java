package com.littlefisher.blog.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import java.util.List;

import com.littlefisher.blog.enums.EnumPostType;

/**
 * Description: AddPostRequest.java
 *
 * Created on 2018年01月04日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("新增博文参数")
public class AddPostRequest {

    /**
     * 标题
     */
    @ApiModelProperty("标题")
    @NotNull(message = "标题不能为空")
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
    @NotNull(message = "类型不能为空")
    private EnumPostType type;

    /**
     * 文章分类
     */
    @ApiModelProperty("文章分类")
    @NotNull(message = "文章分类不能为空")
    private String archiveName;

    /**
     * 作者主键
     */
    @ApiModelProperty("作者主键")
    @Column(name = "author_id")
    private Long authorId;

    /**
     * 博文
     */
    @ApiModelProperty("博文")
    @NotNull(message = "博文不能为空")
    private String content;

    /**
     * 标签列表
     */
    @ApiModelProperty("标签列表")
    private List<String> tagNameList;

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

    public String getArchiveName() {
        return archiveName;
    }

    public void setArchiveName(String archiveName) {
        this.archiveName = archiveName;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getTagNameList() {
        return tagNameList;
    }

    public void setTagNameList(List<String> tagNameList) {
        this.tagNameList = tagNameList;
    }

    @Override
    public String toString() {
        return "AddPostRequest{" + "title='" + title + '\'' + ", originalUrl='" + originalUrl + '\'' + ", type=" +
                type + ", archiveName=" + archiveName + ", authorId=" + authorId + ", content='" + content + '\'' +
                ", tagNameList=" + tagNameList + '}';
    }
}
