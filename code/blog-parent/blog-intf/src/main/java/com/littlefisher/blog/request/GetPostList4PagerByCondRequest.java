package com.littlefisher.blog.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import com.littlefisher.core.biz.framework.request.common.PagerRequest;

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
public class GetPostList4PagerByCondRequest extends PagerRequest {

    /**
     * title 标题，模糊查询
     */
    @ApiModelProperty("标题，模糊查询")
    private String title;

    /** 博文分类id */
    @ApiModelProperty("博文分类id")
    private Long archiveId;

    /**
     * keyword 关键字，针对于博文，模糊查询
     */
    @ApiModelProperty("关键字，针对于博文，模糊查询")
    private String keyword;

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

    public Long getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Long archiveId) {
        this.archiveId = archiveId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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
        return "GetPostList4PagerByCondRequest{" + "title='" + title + '\'' + ", archiveId=" + archiveId +
                ", keyword='" + keyword + '\'' + ", createdDateStart=" + createdDateStart + ", createdDateEnd=" +
                createdDateEnd + "} " + super.toString();
    }
}
