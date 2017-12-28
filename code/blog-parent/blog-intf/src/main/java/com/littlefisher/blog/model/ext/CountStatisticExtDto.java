package com.littlefisher.blog.model.ext;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.littlefisher.blog.model.CountStatistic4BlogDto;
import com.littlefisher.blog.model.CountStatistic4PostDto;
import com.littlefisher.blog.model.CountStatisticDto;

/**
 * Description: CountStatisticExtDto.java
 *
 * Created on 2017年12月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("数量统计实体")
public class CountStatisticExtDto extends CountStatisticDto {

    /** serialVersionUID */
    private static final long serialVersionUID = -1041621211984154151L;

    /** 针对于博客的数据统计 */
    @ApiModelProperty("针对于博客的数据统计")
    private CountStatistic4BlogDto countStatistic4Blog;

    /** 针对于博文的数据统计 */
    @ApiModelProperty("针对于博文的数据统计")
    private CountStatistic4PostDto countStatistic4Post;

    public CountStatistic4BlogDto getCountStatistic4Blog() {
        return countStatistic4Blog;
    }

    public void setCountStatistic4Blog(CountStatistic4BlogDto countStatistic4Blog) {
        this.countStatistic4Blog = countStatistic4Blog;
    }

    public CountStatistic4PostDto getCountStatistic4Post() {
        return countStatistic4Post;
    }

    public void setCountStatistic4Post(CountStatistic4PostDto countStatistic4Post) {
        this.countStatistic4Post = countStatistic4Post;
    }

    @Override
    public String toString() {
        return "CountStatisticExtDto{" + "countStatistic4Blog=" + countStatistic4Blog + ", countStatistic4Post=" +
                countStatistic4Post + "} " + super.toString();
    }
}
