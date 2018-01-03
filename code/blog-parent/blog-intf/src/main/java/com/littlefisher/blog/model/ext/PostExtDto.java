package com.littlefisher.blog.model.ext;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Transient;

import com.littlefisher.blog.model.PostDto;
import com.littlefisher.core.biz.framework.model.UserDto;

/**
 * Description: PostExtDto.java
 *
 * Created on 2017年12月27日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("博文实体")
public class PostExtDto extends PostDto {

    /** serialVersionUID */
    private static final long serialVersionUID = -1797683355874863046L;

    /** 作者 */
    @ApiModelProperty("作者")
    @Transient
    private UserDto author;

    /** 博文统计数据 */
    @ApiModelProperty("博文统计数据")
    @Transient
    private CountStatisticExtDto countStatistic4Post;

    public UserDto getAuthor() {
        return author;
    }

    public void setAuthor(UserDto author) {
        this.author = author;
    }

    public CountStatisticExtDto getCountStatistic4Post() {
        return countStatistic4Post;
    }

    public void setCountStatistic4Post(CountStatisticExtDto countStatistic4Post) {
        this.countStatistic4Post = countStatistic4Post;
    }

    @Override
    public String toString() {
        return "PostExtDto{" + "author=" + author + ", countStatistic4Post=" + countStatistic4Post + "} " +
                super.toString();
    }
}
