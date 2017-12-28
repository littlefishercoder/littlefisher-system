package com.littlefisher.blog.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.littlefisher.core.biz.framework.request.common.PagerRequest;

/**
 * Description: GetPostList4IndexPagerByCondRequest.java
 *
 * Created on 2017年12月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("首页查询博文列表")
public class GetPostList4IndexPagerByCondRequest extends PagerRequest {

    /** 作者id */
    @ApiModelProperty("作者id")
    private String authorId;

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "GetPostList4IndexPagerByCondRequest{" + "authorId='" + authorId + '\'' + "} " + super.toString();
    }
}
