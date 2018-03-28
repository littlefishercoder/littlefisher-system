package com.littlefisher.blog.dal.param;

import java.io.Serializable;
import java.util.Date;

/**
 * Description: SelectPost4PageByCondParam
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class SelectPost4PageByCondParam implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -1721346556190950468L;

    /**
     * title 标题，模糊查询
     */
    private String title;

    /** 作者id */
    private Long authorId;

    /** 博文分类id */
    private Long archiveId;

    /**
     * createdDateStart 创建时间，时间范围的开始时间
     */
    private Date createdDateStart;

    /**
     * createdDateEnd 创建时间，时间范围的结束时间
     */
    private Date createdDateEnd;

    public static class Builder {

        private SelectPost4PageByCondParam instance = new SelectPost4PageByCondParam();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addTitle(String title) {
            this.instance.setTitle(title);
            return this;
        }

        public Builder addAuthorId(Long authorId) {
            this.instance.setAuthorId(authorId);
            return this;
        }

        public Builder addArchiveId(Long archiveId) {
            this.instance.setArchiveId(archiveId);
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

        public SelectPost4PageByCondParam build() {
            return this.instance;
        }
    }

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
        return "SelectPost4PageByCondParam{" + "title='" + title + '\'' + ", authorId=" + authorId + ", archiveId="
            + archiveId + ", createdDateStart=" + createdDateStart + ", createdDateEnd=" + createdDateEnd + '}';
    }
}
