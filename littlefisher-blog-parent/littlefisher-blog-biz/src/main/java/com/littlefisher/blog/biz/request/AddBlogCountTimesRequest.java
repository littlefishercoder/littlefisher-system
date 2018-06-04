package com.littlefisher.blog.biz.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

/**
 * Description: AddBlogCountTimesRequest.java
 *
 * Created on 2017年12月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("增加博客统计信息")
public class AddBlogCountTimesRequest implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 398861863758395311L;

    /** 作者id */
    @ApiModelProperty(required = true, value = "作者id")
    @NotBlank(message = "作者id不能为空")
    @NotNull(message = "作者id不能为空")
    private Long authorId;

    /** 新增评论数量 */
    @ApiModelProperty("新增评论数量")
    @Min(0)
    private Long addCommentedTimes;

    /** 新增访问数量 */
    @ApiModelProperty("新增访问数量")
    @Min(0)
    private Long addVisitedTimes;

    public static final class Builder {

        private AddBlogCountTimesRequest instance = new AddBlogCountTimesRequest();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addAuthorId(Long authorId) {
            this.instance.setAuthorId(authorId);
            return this;
        }

        public Builder addAddCommentedTimes(Long addCommentedTimes) {
            this.instance.setAddCommentedTimes(addCommentedTimes);
            return this;
        }

        public Builder addAddVisitedTimes(Long addVisitedTimes) {
            this.instance.setAddVisitedTimes(addVisitedTimes);
            return this;
        }

        public AddBlogCountTimesRequest build() {
            return this.instance;
        }
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getAddCommentedTimes() {
        return addCommentedTimes;
    }

    public void setAddCommentedTimes(Long addCommentedTimes) {
        this.addCommentedTimes = addCommentedTimes;
    }

    public Long getAddVisitedTimes() {
        return addVisitedTimes;
    }

    public void setAddVisitedTimes(Long addVisitedTimes) {
        this.addVisitedTimes = addVisitedTimes;
    }

    @Override
    public String toString() {
        return "AddBlogCountTimesRequest{" + "authorId=" + authorId + ", addCommentedTimes=" + addCommentedTimes
            + ", addVisitedTimes=" + addVisitedTimes + '}';
    }
}
