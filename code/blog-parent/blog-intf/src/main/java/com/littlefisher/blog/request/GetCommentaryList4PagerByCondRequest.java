package com.littlefisher.blog.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import com.littlefisher.core.biz.framework.request.common.PagerRequest;

/**
 * Description: 查询评价列表条件
 * <p>
 * Created on 2017年5月23日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("查询评价列表条件")
public class GetCommentaryList4PagerByCondRequest extends PagerRequest {

    /**
     * postId 博文主键
     */
    @ApiModelProperty("博文主键")
    private Long postId;

    /**
     * keyword 关键字，针对评价博湖查询
     */
    @ApiModelProperty("关键字，针对评价博湖查询")
    private String keyword;

    /**
     * createdDateStart 创建时间，时间范围开始
     */
    @ApiModelProperty("创建时间，时间范围开始")
    private Date createdDateStart;

    /**
     * createdDateEnd 创建时间，时间范围结束
     */
    @ApiModelProperty("创建时间，时间范围结束")
    private Date createdDateEnd;

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
        return "GetCommentaryList4PagerByCondRequest{" + "postId=" + postId + ", keyword='" + keyword + '\'' +
                ", createdDateStart=" + createdDateStart + ", createdDateEnd=" + createdDateEnd + "} " +
                super.toString();
    }
}
