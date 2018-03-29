package com.littlefisher.blog.biz.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import com.littlefisher.core.biz.framework.model.UserBizDto;

/**
 *
 * @author jinyn22648
 * @version $$Id: CommentaryBizExtDto.java, v 0.1 2018/3/23 下午12:35 jinyn22648 Exp $$
 */
@ApiModel("评价相关详细信息")
public class CommentaryBizExtDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 8409069686018844664L;

    /** 评价 */
    @ApiModelProperty("")
    private CommentaryBizDto commentaryBizDto;

    /** 评价人 */
    @ApiModelProperty("")
    private UserBizDto userBizDto;

    public static class Builder {

        private CommentaryBizExtDto instance = new CommentaryBizExtDto();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addCommentaryBizDto(CommentaryBizDto commentaryBizDto) {
            this.instance.setCommentaryBizDto(commentaryBizDto);
            return this;
        }

        public Builder addUserBizDto(UserBizDto userBizDto) {
            this.instance.setUserBizDto(userBizDto);
            return this;
        }

        public CommentaryBizExtDto build() {
            return this.instance;
        }
    }

    public CommentaryBizDto getCommentaryBizDto() {
        return commentaryBizDto;
    }

    public void setCommentaryBizDto(CommentaryBizDto commentaryBizDto) {
        this.commentaryBizDto = commentaryBizDto;
    }

    public UserBizDto getUserBizDto() {
        return userBizDto;
    }

    public void setUserBizDto(UserBizDto userBizDto) {
        this.userBizDto = userBizDto;
    }

    @Override
    public String toString() {
        return "CommentaryBizExtDto{" + "commentaryBizDto=" + commentaryBizDto + ", userBizDto=" + userBizDto + '}';
    }
}
