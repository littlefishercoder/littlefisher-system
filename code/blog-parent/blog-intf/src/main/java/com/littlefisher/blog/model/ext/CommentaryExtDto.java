package com.littlefisher.blog.model.ext;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Transient;

import java.io.Serializable;

import com.littlefisher.blog.model.CommentaryDto;
import com.littlefisher.core.biz.framework.model.user.UserDto;

/**
 * Description: CommentaryExtDto.java
 *
 * Created on 2017年12月27日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class CommentaryExtDto extends CommentaryDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 2862852923258309514L;

    /** 评价人 */
    @ApiModelProperty("评价人")
    @Transient
    private UserDto user;

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CommentaryExtDto{" + "user=" + user + "} " + super.toString();
    }
}
