package com.littlefisher.blog.biz.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import com.littlefisher.core.mybatis.pagehelper.PageParam;

/**
 * Description:
 * <p>
 * Created on 2017年5月23日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("查询博文列表的入参条件，分页用")
public class GetPostList4PageByCondRequest extends PageParam {

    /** serialVersionUID */
    private static final long serialVersionUID = 4031692986695735776L;

    /**
     * title 标题，模糊查询
     */
    @ApiModelProperty("标题，模糊查询")
    private String title;

    /** 作者id */
    @ApiModelProperty("作者id")
    private Long authorId;

    /** 博文分类id */
    @ApiModelProperty("博文分类id")
    private Long archiveId;

    /**
     * createdDateStart 创建时间，时间范围的开始时间
     */
    @ApiModelProperty("创建时间，时间范围的开始时间")
    private Date createdDateStart;

    /**
     * createdDateEnd 创建时间，时间范围的结束时间
     */
    @ApiModelProperty("创建时间，时间范围的结束时间")
    private Date createdDateEnd;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Long archiveId) {
        this.archiveId = archiveId;
    }

    public Date getCreatedDateStart() {
        return createdDateStart;
    }

    public void setCreatedDateStart(Date createdDateStart) {
        this.createdDateStart = createdDateStart;
    }

    public Date getCreatedDateEnd() {
        return createdDateEnd;
    }

    public void setCreatedDateEnd(Date createdDateEnd) {
        this.createdDateEnd = createdDateEnd;
    }

    @Override
    public String toString() {
        return "GetPostList4PageByCondRequest{" + "title='" + title + '\'' + ", authorId=" + authorId +
                ", archiveId=" + archiveId + ", createdDateStart=" + createdDateStart + ", createdDateEnd=" +
                createdDateEnd + "} " + super.toString();
    }
}
