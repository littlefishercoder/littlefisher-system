package com.littlefisher.blog.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.sf.oval.constraint.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

import com.littlefisher.blog.enums.EnumCommentaryState;

/**
 * Description: UpdateCommentaryRequest.java
 *
 * Created on 2018年02月05日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("修改评价请求")
public class UpdateCommentaryRequest implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -1516730940853284888L;

    /** id */
    @ApiModelProperty(required = true, value = "id")
    @NotNull(message = "评价id不能为空")
    @NotBlank(message = "评价id不能为空")
    private Long id;

    /** 状态 */
    @ApiModelProperty("状态")
    private EnumCommentaryState state;

    /** 评论内容 */
    @ApiModelProperty(required = true, value = "评论内容")
    @NotNull(message = "评价内容不能为空")
    @NotBlank(message = "评价内容不能为空")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnumCommentaryState getState() {
        return state;
    }

    public void setState(EnumCommentaryState state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "UpdateCommentaryRequest{" + "id=" + id + ", state=" + state + ", content='" + content + '\'' + '}';
    }
}
