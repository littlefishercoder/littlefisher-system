package com.littlefisher.blog.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Description: GetTagList4PagerByCondRequest.java
 *
 * Created on 2017年12月27日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("查询标签列表的入参条件，分页用")
public class GetTagList4PagerByCondRequest {

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

    @Override
    public String toString() {
        return "GetTagList4PagerByCondRequest{" + "pageNum=" + pageNum + ", pageSize=" + pageSize + '}';
    }
}
