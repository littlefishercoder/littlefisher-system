package com.littlefisher.blog.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 *
 * Description: count_statistic_4_post 实体
 *
 * Created on 2018年01月03日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "count_statistic_4_post")
@ApiModel("count_statistic_4_post实体")
public class CountStatistic4PostDto implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 数量统计主键
     */
    @ApiModelProperty("数量统计主键")
    @Id
    @Column(name = "count_statistic_id")
    private Long countStatisticId;

    /**
     * 博文主键
     */
    @ApiModelProperty("博文主键")
    @Column(name = "post_id")
    private Long postId;

    /**
     * 阅读数
     */
    @ApiModelProperty("阅读数")
    @Column(name = "read_times")
    private Long readTimes;

    /**
     * 评论数
     */
    @ApiModelProperty("评论数")
    @Column(name = "commented_times")
    private Long commentedTimes;

    /**
     * 点赞数
     */
    @ApiModelProperty("点赞数")
    @Column(name = "liked_times")
    private Long likedTimes;

    public Long getCountStatisticId() {
        return countStatisticId;
    }

    public void setCountStatisticId(Long countStatisticId) {
        this.countStatisticId = countStatisticId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getReadTimes() {
        return readTimes;
    }

    public void setReadTimes(Long readTimes) {
        this.readTimes = readTimes;
    }

    public Long getCommentedTimes() {
        return commentedTimes;
    }

    public void setCommentedTimes(Long commentedTimes) {
        this.commentedTimes = commentedTimes;
    }

    public Long getLikedTimes() {
        return likedTimes;
    }

    public void setLikedTimes(Long likedTimes) {
        this.likedTimes = likedTimes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", countStatisticId=").append(countStatisticId);
        sb.append(", postId=").append(postId);
        sb.append(", readTimes=").append(readTimes);
        sb.append(", commentedTimes=").append(commentedTimes);
        sb.append(", likedTimes=").append(likedTimes);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}