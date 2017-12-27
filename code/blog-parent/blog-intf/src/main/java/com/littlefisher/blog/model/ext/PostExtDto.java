package com.littlefisher.blog.model.ext;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Transient;
import java.io.Serializable;

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
public class PostExtDto extends PostDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -1797683355874863046L;

    /** 作者 */
    @ApiModelProperty("作者")
    @Transient
    private UserDto author;

    public UserDto getAuthor() {
        return author;
    }

    public void setAuthor(UserDto author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "PostExtDto{" + "author=" + author + "} " + super.toString();
    }
}
