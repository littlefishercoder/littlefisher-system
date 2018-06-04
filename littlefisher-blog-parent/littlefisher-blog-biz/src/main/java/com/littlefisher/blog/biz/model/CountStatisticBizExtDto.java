package com.littlefisher.blog.biz.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author jinyn22648
 * @version $$Id: CountStatisticBizExtDto.java, v 0.1 2018/3/23 下午12:36 jinyn22648 Exp $$
 */
@ApiModel("统计详细信息")
public class CountStatisticBizExtDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -7464714177024253047L;

    /** 统计 */
    @ApiModelProperty("统计")
    private CountStatisticBizDto countStatistic;

    /** 针对于博客的数据统计 */
    @ApiModelProperty("针对于博客的数据统计")
    private CountStatistic4BlogBizDto countStatistic4Blog;

    /** 针对于博文的数据统计 */
    @ApiModelProperty("针对于博文的数据统计")
    private CountStatistic4PostBizDto countStatistic4Post;

    public static final class Builder {

        private CountStatisticBizExtDto instance = new CountStatisticBizExtDto();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addCountStatistic(CountStatisticBizDto countStatistic) {
            this.instance.setCountStatistic(countStatistic);
            return this;
        }

        public Builder addCountStatistic4Blog(CountStatistic4BlogBizDto countStatistic4Blog) {
            this.instance.setCountStatistic4Blog(countStatistic4Blog);
            return this;
        }

        public Builder addCountStatistic4Post(CountStatistic4PostBizDto countStatistic4Post) {
            this.instance.setCountStatistic4Post(countStatistic4Post);
            return this;
        }

        public CountStatisticBizExtDto build() {
            return this.instance;
        }
    }

    public CountStatisticBizDto getCountStatistic() {
        return countStatistic;
    }

    public void setCountStatistic(CountStatisticBizDto countStatistic) {
        this.countStatistic = countStatistic;
    }

    public CountStatistic4BlogBizDto getCountStatistic4Blog() {
        return countStatistic4Blog;
    }

    public void setCountStatistic4Blog(CountStatistic4BlogBizDto countStatistic4Blog) {
        this.countStatistic4Blog = countStatistic4Blog;
    }

    public CountStatistic4PostBizDto getCountStatistic4Post() {
        return countStatistic4Post;
    }

    public void setCountStatistic4Post(CountStatistic4PostBizDto countStatistic4Post) {
        this.countStatistic4Post = countStatistic4Post;
    }

    @Override
    public String toString() {
        return "CountStatisticBizExtDto{" + "countStatistic=" + countStatistic + ", countStatistic4Blog="
            + countStatistic4Blog + ", countStatistic4Post=" + countStatistic4Post + '}';
    }
}
