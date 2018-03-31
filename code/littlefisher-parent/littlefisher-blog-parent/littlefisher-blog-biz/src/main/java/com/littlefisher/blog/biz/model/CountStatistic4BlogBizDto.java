package com.littlefisher.blog.biz.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *
 * @author jinyn22648
 * @version $$Id: CountStatistic4BlogBizDto.java, v 0.1 2018/3/27 下午7:27 jinyn22648 Exp $$
 */
@ApiModel("博客统计")
public class CountStatistic4BlogBizDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -1560343975054099102L;

    /**
     * 数量统计主键
     */
    @ApiModelProperty("数量统计主键")
    private Long countStatisticId;

    /**
     * 访问量
     */
    @ApiModelProperty("访问量")
    private Long visitedTimes;

    /**
     * 评论量（针对于博客的）
     */
    @ApiModelProperty("评论量（针对于博客的）")
    private Long commentedTimes;

    public static class Builder {

        private CountStatistic4BlogBizDto instance = new CountStatistic4BlogBizDto();

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

        public CountStatistic4BlogBizDto build() {
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
        return "CountStatistic4BlogBizDto{" + "countStatisticId=" + countStatisticId + ", visitedTimes=" + visitedTimes
            + ", commentedTimes=" + commentedTimes + '}';
    }
}
