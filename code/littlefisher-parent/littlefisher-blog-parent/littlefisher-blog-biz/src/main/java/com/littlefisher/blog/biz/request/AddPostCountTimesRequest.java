package com.littlefisher.blog.biz.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.sf.oval.constraint.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Description: AddPostCountTimesRequest.java
 *
 * Created on 2017年12月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("增加博文统计数据")
public class AddPostCountTimesRequest {

    /** 博文id */
    @ApiModelProperty(required = true, value = "博文id")
    @NotNull(message = "博文id不能为空")
    @NotBlank(message = "博文id不能为空")
    private Long postId;

    /** 新增评价数 */
    @ApiModelProperty("新增评价数")
    @Min(0)
    private Long addCommentedTimes;

    /** 新增点赞数 */
    @ApiModelProperty("新增点赞数")
    @Min(0)
    private Long addLikedTimes;

    /** 新增访问数 */
    @ApiModelProperty("新增阅读数")
    @Min(0)
    private Long addReadTimes;

    public static class Builder {

        private AddPostCountTimesRequest instance = new AddPostCountTimesRequest();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addPostId(Long postId) {
            this.instance.setPostId(postId);
            return this;
        }

        public Builder addAddCommentedTimes(Long addCommentedTimes) {
            this.instance.setAddCommentedTimes(addCommentedTimes);
            return this;
        }

        public Builder addAddLikedTimes(Long addLikedTimes) {
            this.instance.setAddLikedTimes(addLikedTimes);
            return this;
        }

        public Builder addAddReadTimes(Long addReadTimes) {
            this.instance.setAddReadTimes(addReadTimes);
            return this;
        }

        public AddPostCountTimesRequest build() {
            return this.instance;
        }
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getAddCommentedTimes() {
        return addCommentedTimes;
    }

    public void setAddCommentedTimes(Long addCommentedTimes) {
        this.addCommentedTimes = addCommentedTimes;
    }

    public Long getAddLikedTimes() {
        return addLikedTimes;
    }

    public void setAddLikedTimes(Long addLikedTimes) {
        this.addLikedTimes = addLikedTimes;
    }

    public Long getAddReadTimes() {
        return addReadTimes;
    }

    public void setAddReadTimes(Long addReadTimes) {
        this.addReadTimes = addReadTimes;
    }

    @Override
    public String toString() {
        return "AddPostCountTimesRequest{" + "postId=" + postId + ", addCommentedTimes=" + addCommentedTimes
            + ", addLikedTimes=" + addLikedTimes + ", addReadTimes=" + addReadTimes + '}';
    }
}
