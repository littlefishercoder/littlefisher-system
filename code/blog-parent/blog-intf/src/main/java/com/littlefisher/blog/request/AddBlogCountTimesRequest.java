package com.littlefisher.blog.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Description: AddBlogCountTimesRequest.java
 *
 * Created on 2017年12月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("增加博客统计信息")
public class AddBlogCountTimesRequest {

    /** 作者id */
    @ApiModelProperty("作者id")
    private Long authorId;

    /** 新增评论数量 */
    @ApiModelProperty("新增评论数量")
    private Long addCommentedTimes;

    /** 新增访问数量 */
    @ApiModelProperty("新增访问数量")
    private Long addVisitedTimes;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getAddCommentedTimes() {
        return addCommentedTimes;
    }

    public void setAddCommentedTimes(Long addCommentedTimes) {
        this.addCommentedTimes = addCommentedTimes;
    }

    public Long getAddVisitedTimes() {
        return addVisitedTimes;
    }

    public void setAddVisitedTimes(Long addVisitedTimes) {
        this.addVisitedTimes = addVisitedTimes;
    }

    @Override
    public String toString() {
        return "AddBlogCountTimesRequest{" + "authorId=" + authorId + ", addCommentedTimes=" + addCommentedTimes +
                ", addVisitedTimes=" + addVisitedTimes + '}';
    }
}
