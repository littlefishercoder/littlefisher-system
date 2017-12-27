package com.littlefisher.blog.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;


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
public class GetPostList4PagerByCondRequest {

    /**
     * pageNum
     */
    @ApiModelProperty("页码")
    private int pageNum;

    /**
     * pageSize 每页行数
     */
    @ApiModelProperty("每页行数")
    private int pageSize;

    /**
     * title 标题，模糊查询
     */
    @ApiModelProperty("标题，模糊查询")
    private String title;

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

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        StringBuilder builder = new StringBuilder();
        builder.append("GetPostList4PagerByCondRequest [pageNum=");
        builder.append(pageNum);
        builder.append(", pageSize=");
        builder.append(pageSize);
        builder.append(", title=");
        builder.append(title);
        builder.append(", keyword=");
        builder.append(keyword);
        builder.append(", createdDateStart=");
        builder.append(createdDateStart);
        builder.append(", createdDateEnd=");
        builder.append(createdDateEnd);
        builder.append("]");
        return builder.toString();
    }


}
