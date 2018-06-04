package com.littlefisher.blog.biz.request;

import java.io.Serializable;

import com.littlefisher.core.common.utils.StringUtil;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.sf.oval.constraint.CheckWith;
import net.sf.oval.constraint.CheckWithCheck;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

/**
 * Description: AddCommentaryRequest.java
 *
 * Created on 2018年02月05日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("新增评价请求")
public class AddCommentaryRequest implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -3491452336833574961L;

    /**
     * 父评价主键
     */
    @ApiModelProperty("父评价主键")
    private Long parentCommentaryId;

    /**
     * 评价人主键和昵称二选一，评价人主键为空说明是匿名评价，则必须有昵称来展示
     */
    @ApiModelProperty("评价人主键和昵称二选一，评价人主键为空说明是匿名评价，则必须有昵称来展示")
    @CheckWith(value = NameCheck.class, message = "评价人主键和昵称二选一")
    private Long userId;

    /**
     * 评价人主键和昵称二选一，评价人主键为空说明是匿名评价，则必须有昵称来展示
     */
    @ApiModelProperty("评价人主键和昵称二选一，评价人主键为空说明是匿名评价，则必须有昵称来展示")
    private String nickName;

    /**
     * ip地址
     */
    @ApiModelProperty("ip地址")
    private String commentaryIp;

    /**
     * 博文主键
     */
    @ApiModelProperty(required = true, value = "博文主键")
    @NotNull(message = "博文主键不能为空")
    @NotBlank(message = "博文主键不能为空")
    private Long postId;

    /**
     * 评论内容
     */
    @ApiModelProperty(required = true, value = "评论内容")
    @NotNull(message = "评价内容不能为空")
    @NotBlank(message = "评价内容不能为空")
    private String content;

    public static class NameCheck implements CheckWithCheck.SimpleCheck {

        /** serialVersionUID */
        private static final long serialVersionUID = 4258982788288498768L;

        @Override
        public boolean isSatisfied(Object validatedObject, Object value) {
            AddCommentaryRequest request = (AddCommentaryRequest) validatedObject;
            Long userId = (Long) value;
            return userId != null || StringUtil.isNotBlank(request.getNickName());
        }
    }

    public Long getParentCommentaryId() {
        return parentCommentaryId;
    }

    public void setParentCommentaryId(Long parentCommentaryId) {
        this.parentCommentaryId = parentCommentaryId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCommentaryIp() {
        return commentaryIp;
    }

    public void setCommentaryIp(String commentaryIp) {
        this.commentaryIp = commentaryIp;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AddCommentaryRequest{" + "parentCommentaryId=" + parentCommentaryId + ", userId=" + userId
            + ", nickName='" + nickName + '\'' + ", commentaryIp='" + commentaryIp + '\'' + ", postId=" + postId
            + ", content='" + content + '\'' + '}';
    }
}
