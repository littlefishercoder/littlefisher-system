package com.littlefisher.core.mybatis.pagehelper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Description: PageParam.java
 *
 * Created on 2017年12月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("分页参数")
public class PageParam {

    /**
     * pageNum
     */
    @ApiModelProperty("页码，默认第一页")
    private int pageNum = 1;

    /**
     * pageSize 每页行数
     */
    @ApiModelProperty("每页行数，默认每页20行")
    private int pageSize = 20;

    public static class Builder {

        private PageParam instance = new PageParam();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addPageNum(int pageNum) {
            this.instance.setPageNum(pageNum);
            return this;
        }

        public Builder addPageSize(int pageSize) {
            this.instance.setPageSize(pageSize);
            return this;
        }

        public PageParam build() {
            return this.instance;
        }
    }

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
        return "PageParam{" + "pageNum=" + pageNum + ", pageSize=" + pageSize + '}';
    }
}
