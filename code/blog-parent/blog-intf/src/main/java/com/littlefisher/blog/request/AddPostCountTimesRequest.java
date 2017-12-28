package com.littlefisher.blog.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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

    /** 作者id */
    @ApiModelProperty("作者id")
    private Long authorId;

    /** 博文id */
    @ApiModelProperty("博文id")
    private Long postId;

    /** 新增评价数 */
    @ApiModelProperty("新增评价数")
    private Long addCommentedTimes;

    /** 新增点赞数 */
    @ApiModelProperty("新增点赞数")
    private Long addLikedTimes;

    /** 新增访问数 */
    @ApiModelProperty("新增阅读数")
    private Long addReadTimes;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
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
        return "AddPostCountTimesRequest{" + "authorId=" + authorId + ", postId=" + postId + ", addCommentedTimes=" +
                addCommentedTimes + ", addLikedTimes=" + addLikedTimes + ", addReadTimes=" + addReadTimes + '}';
    }
}
