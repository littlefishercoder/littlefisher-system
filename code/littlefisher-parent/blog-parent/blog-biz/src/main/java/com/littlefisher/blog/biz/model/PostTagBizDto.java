package com.littlefisher.blog.biz.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import com.littlefisher.blog.common.enums.EnumPostTagState;

/**
 *
 * @author jinyn22648
 * @version $$Id: PostTagBizDto.java, v 0.1 2018/3/23 下午12:38 jinyn22648 Exp $$
 */
@ApiModel("博文tag关联")
public class PostTagBizDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 8629805402995412985L;

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private Long id;

    /**
     * 博文主键
     */
    @ApiModelProperty("博文主键")
    private Long postId;

    /**
     * 标签主键
     */
    @ApiModelProperty("标签主键")
    private Long tagId;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createDate;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private EnumPostTagState state;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date updateDate;

    public static class Builder {

        private PostTagBizDto instance = new PostTagBizDto();

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

        public PostTagBizDto build() {
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
        return "PostTagBizDto{" + "id=" + id + ", postId=" + postId + ", tagId=" + tagId + ", createDate=" + createDate
            + ", state=" + state + ", updateDate=" + updateDate + '}';
    }
}
