package com.littlefisher.blog.model.ext;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Transient;

import java.util.List;

import com.littlefisher.blog.model.ArchiveDto;
import com.littlefisher.blog.model.PostDto;
import com.littlefisher.blog.model.TagDto;
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
    private AuthorExtDto author;

    /** 文章归档类型 */
    @ApiModelProperty("文章归档类型")
    @Transient
    private ArchiveDto archive;

    /** 标签列表 */
    @ApiModelProperty("标签列表")
    @Transient
    private List<TagDto> tagList;

    /** 博文统计数据 */
    @ApiModelProperty("博文统计数据")
    @Transient
    private CountStatisticExtDto countStatistic4Post;

    public AuthorExtDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorExtDto author) {
        this.author = author;
    }

    public ArchiveDto getArchive() {
        return archive;
    }

    public void setArchive(ArchiveDto archive) {
        this.archive = archive;
    }

    public List<TagDto> getTagList() {
        return tagList;
    }

    public void setTagList(List<TagDto> tagList) {
        this.tagList = tagList;
    }

    public CountStatisticExtDto getCountStatistic4Post() {
        return countStatistic4Post;
    }

    public void setCountStatistic4Post(CountStatisticExtDto countStatistic4Post) {
        this.countStatistic4Post = countStatistic4Post;
    }

    @Override
    public String toString() {
        return "PostExtDto{" + "author=" + author + ", archive=" + archive + ", tagList=" + tagList +
                ", countStatistic4Post=" + countStatistic4Post + "} " + super.toString();
    }
}
