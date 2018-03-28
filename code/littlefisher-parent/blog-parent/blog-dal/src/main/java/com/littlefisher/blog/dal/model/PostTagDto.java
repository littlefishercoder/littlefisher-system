package com.littlefisher.blog.dal.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

import com.littlefisher.blog.common.enums.EnumPostTagState;

/**
 *
 * Description: post_tag 实体
 *
 * Created on 2018年01月10日
 * 
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "post_tag")
public class PostTagDto implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 博文主键
     */
    @Column(name = "post_id")
    private Long postId;

    /**
     * 标签主键
     */
    @Column(name = "tag_id")
    private Long tagId;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 状态
     */
    private EnumPostTagState state;

    /**
     * 修改时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    public static class Builder {

        private PostTagDto instance = new PostTagDto();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addId(Long id) {
            this.instance.setId(id);
            return this;
        }

        public Builder addPostId(Long postId) {
            this.instance.setPostId(postId);
            return this;
        }

        public Builder addTagId(Long tagId) {
            this.instance.setTagId(tagId);
            return this;
        }

        public Builder addCreateDate(Date createDate) {
            this.instance.setCreateDate(createDate);
            return this;
        }

        public Builder addState(EnumPostTagState state) {
            this.instance.setState(state);
            return this;
        }

        public Builder addUpdateDate(Date updateDate) {
            this.instance.setUpdateDate(updateDate);
            return this;
        }

        public PostTagDto build() {
            return this.instance;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public EnumPostTagState getState() {
        return state;
    }

    public void setState(EnumPostTagState state) {
        this.state = state;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", postId=").append(postId);
        sb.append(", tagId=").append(tagId);
        sb.append(", createDate=").append(createDate);
        sb.append(", state=").append(state);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}