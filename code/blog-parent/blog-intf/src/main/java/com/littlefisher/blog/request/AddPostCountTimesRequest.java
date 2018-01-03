package com.littlefisher.blog.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
    @ApiModelProperty("博文id")
    @NotNull
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
        return "AddPostCountTimesRequest{" + "postId=" + postId + ", addCommentedTimes=" + addCommentedTimes +
                ", addLikedTimes=" + addLikedTimes + ", addReadTimes=" + addReadTimes + '}';
    }
}
