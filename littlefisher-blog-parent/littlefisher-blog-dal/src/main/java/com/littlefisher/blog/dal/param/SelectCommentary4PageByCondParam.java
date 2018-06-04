package com.littlefisher.blog.dal.param;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jinyn22648
 * @version $$Id: SelectCommentary4PageByCondParam.java, v 0.1 2018/3/27 下午3:43 jinyn22648 Exp $$
 */
public class SelectCommentary4PageByCondParam implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1766621074880004978L;

    /**
     * postId 博文主键
     */
    private Long postId;

    /**
     * keyword 关键字，针对评价博湖查询
     */
    private String keyword;

    /**
     * createdDateStart 创建时间，时间范围开始
     */
    private Date createdDateStart;

    /**
     * createdDateEnd 创建时间，时间范围结束
     */
    private Date createdDateEnd;

    public static final class Builder {

        private SelectCommentary4PageByCondParam instance = new SelectCommentary4PageByCondParam();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addPostId(Long postId) {
            this.instance.setPostId(postId);
            return this;
        }

        public Builder addKeyword(String keyword) {
            this.instance.setKeyword(keyword);
            return this;
        }

        public Builder addCreatedDateStart(Date createdDateStart) {
            this.instance.setCreatedDateStart(createdDateStart);
            return this;
        }

        public Builder addCreatedDateEnd(Date createdDateEnd) {
            this.instance.setCreatedDateEnd(createdDateEnd);
            return this;
        }

        public SelectCommentary4PageByCondParam build() {
            return this.instance;
        }
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
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
        return "SelectCommentary4PageByCondParam{" + "postId=" + postId + ", keyword='" + keyword + '\''
            + ", createdDateStart=" + createdDateStart + ", createdDateEnd=" + createdDateEnd + '}';
    }
}
