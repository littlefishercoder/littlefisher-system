package com.littlefisher.blog.biz.model;

import java.io.Serializable;

/**
 *
 * @author jinyn22648
 * @version $$Id: CountStatistic4PostBizDto.java, v 0.1 2018/3/27 下午7:27 jinyn22648 Exp $$
 */
public class CountStatistic4PostBizDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1666078954503777183L;

    /**
     * 数量统计主键
     */
    private Long countStatisticId;

    /**
     * 博文主键
     */
    private Long postId;

    /**
     * 阅读数
     */
    private Long readTimes;

    /**
     * 评论数
     */
    private Long commentedTimes;

    /**
     * 点赞数
     */
    private Long likedTimes;

    public static class Builder {

        private CountStatistic4PostBizDto instance = new CountStatistic4PostBizDto();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addCountStatisticId(Long countStatisticId) {
            this.instance.setCountStatisticId(countStatisticId);
            return this;
        }

        public Builder addPostId(Long postId) {
            this.instance.setPostId(postId);
            return this;
        }

        public Builder addReadTimes(Long readTimes) {
            this.instance.setReadTimes(readTimes);
            return this;
        }

        public Builder addCommentedTimes(Long commentedTimes) {
            this.instance.setCommentedTimes(commentedTimes);
            return this;
        }

        public Builder addLikedTimes(Long likedTimes) {
            this.instance.setLikedTimes(likedTimes);
            return this;
        }

        public CountStatistic4PostBizDto build() {
            return this.instance;
        }
    }

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
        return "CountStatistic4PostBizDto{" + "countStatisticId=" + countStatisticId + ", postId=" + postId
            + ", readTimes=" + readTimes + ", commentedTimes=" + commentedTimes + ", likedTimes=" + likedTimes + '}';
    }
}
