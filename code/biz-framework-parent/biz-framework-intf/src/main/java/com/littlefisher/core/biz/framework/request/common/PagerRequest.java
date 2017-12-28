package com.littlefisher.core.biz.framework.request.common;

import io.swagger.annotations.ApiModelProperty;

/**
 * Description: PagerRequest.java
 *
 * Created on 2017年12月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class PagerRequest {

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
        return "PagerRequest{" + "pageNum=" + pageNum + ", pageSize=" + pageSize + '}';
    }
}
