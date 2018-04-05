package com.littlefisher.core.mybatis.pagehelper;

import java.io.Serializable;

/**
 * Description: PageParam.java
 *
 * Created on 2017年12月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class PageParam implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 4901705218363381498L;

    /**
     * pageNum
     */
    private int pageNum = 1;

    /**
     * pageSize 每页行数
     */
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
