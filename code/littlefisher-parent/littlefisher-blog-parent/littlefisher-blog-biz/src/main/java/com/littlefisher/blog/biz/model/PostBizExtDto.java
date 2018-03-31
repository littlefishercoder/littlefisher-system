package com.littlefisher.blog.biz.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jinyn22648
 * @version $$Id: PostBizExtDto.java, v 0.1 2018/3/23 下午12:36 jinyn22648 Exp $$
 */
@ApiModel("博文详细信息")
public class PostBizExtDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -2526207235709715979L;

    /** 文章 */
    @ApiModelProperty("文章")
    private PostBizDto post;

    /** 作者 */
    @ApiModelProperty("作者")
    private AuthorBizExtDto author;

    /** 文章归档类型 */
    @ApiModelProperty("文章归档类型")
    private ArchiveBizDto archive;

    /** 标签列表 */
    @ApiModelProperty("标签列表")
    private List<TagBizDto> tagList;

    /** 博文统计数据 */
    @ApiModelProperty("博文统计数据")
    private CountStatisticBizExtDto countStatistic4Post;

    public static class Builder {

        private PostBizExtDto instance = new PostBizExtDto();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addPost(PostBizDto post) {
            this.instance.setPost(post);
            return this;
        }

        public Builder addAuthor(AuthorBizExtDto author) {
            this.instance.setAuthor(author);
            return this;
        }

        public Builder addArchive(ArchiveBizDto archive) {
            this.instance.setArchive(archive);
            return this;
        }

        public Builder addTagList(List<TagBizDto> tagList) {
            this.instance.setTagList(tagList);
            return this;
        }

        public Builder addCountStatistic4Post(CountStatisticBizExtDto countStatistic4Post) {
            this.instance.setCountStatistic4Post(countStatistic4Post);
            return this;
        }

        public PostBizExtDto build() {
            return this.instance;
        }
    }

    public PostBizDto getPost() {
        return post;
    }

    public void setPost(PostBizDto post) {
        this.post = post;
    }

    public AuthorBizExtDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBizExtDto author) {
        this.author = author;
    }

    public ArchiveBizDto getArchive() {
        return archive;
    }

    public void setArchive(ArchiveBizDto archive) {
        this.archive = archive;
    }

    public List<TagBizDto> getTagList() {
        return tagList;
    }

    public void setTagList(List<TagBizDto> tagList) {
        this.tagList = tagList;
    }

    public CountStatisticBizExtDto getCountStatistic4Post() {
        return countStatistic4Post;
    }

    public void setCountStatistic4Post(CountStatisticBizExtDto countStatistic4Post) {
        this.countStatistic4Post = countStatistic4Post;
    }

    @Override
    public String toString() {
        return "PostBizExtDto{" + "post=" + post + ", author=" + author + ", archive=" + archive + ", tagList="
            + tagList + ", countStatistic4Post=" + countStatistic4Post + '}';
    }
}
