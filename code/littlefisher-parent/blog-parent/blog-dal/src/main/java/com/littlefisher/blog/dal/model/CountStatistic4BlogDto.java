package com.littlefisher.blog.dal.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 * Description: count_statistic_4_blog 实体
 *
 * Created on 2018年01月10日
 * 
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "count_statistic_4_blog")
public class CountStatistic4BlogDto implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 数量统计主键
     */
    @Id
    @Column(name = "count_statistic_id")
    private Long countStatisticId;

    /**
     * 访问量
     */
    @Column(name = "visited_times")
    private Long visitedTimes;

    /**
     * 评论量（针对于博客的）
     */
    @Column(name = "commented_times")
    private Long commentedTimes;

    public static class Builder {

        private CountStatistic4BlogDto instance = new CountStatistic4BlogDto();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addCountStatisticId(Long countStatisticId) {
            this.instance.setCountStatisticId(countStatisticId);
            return this;
        }

        public Builder addVisitedTimes(Long visitedTimes) {
            this.instance.setVisitedTimes(visitedTimes);
            return this;
        }

        public Builder addCommentedTimes(Long commentedTimes) {
            this.instance.setCommentedTimes(commentedTimes);
            return this;
        }

        public CountStatistic4BlogDto build() {
            return this.instance;
        }
    }

    public Long getCountStatisticId() {
        return countStatisticId;
    }

    public void setCountStatisticId(Long countStatisticId) {
        this.countStatisticId = countStatisticId;
    }

    public Long getVisitedTimes() {
        return visitedTimes;
    }

    public void setVisitedTimes(Long visitedTimes) {
        this.visitedTimes = visitedTimes;
    }

    public Long getCommentedTimes() {
        return commentedTimes;
    }

    public void setCommentedTimes(Long commentedTimes) {
        this.commentedTimes = commentedTimes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", countStatisticId=").append(countStatisticId);
        sb.append(", visitedTimes=").append(visitedTimes);
        sb.append(", commentedTimes=").append(commentedTimes);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}