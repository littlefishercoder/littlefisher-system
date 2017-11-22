package com.littlefisher.blog.intf.post;

import java.util.List;

import com.littlefisher.blog.model.post.PostTypeDto;

/**
 * Description:
 *
 * Created on 2017年5月25日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IPostTypeService {

    /**
     * Description: 查询所有博文类型
     *
     * @return List<PostTypeDto>
     */
    List<PostTypeDto> getAllPostType();

    /**
     * Description: 新增博文类型
     *
     * @param postTypeDto postTypeDto
     * @return PostTypeDto
     */
    PostTypeDto addPostType(PostTypeDto postTypeDto);

    /**
     * Description: 修改博文类型
     *
     * @param postTypeDto postTypeDto
     * @return PostTypeDto
     */
    PostTypeDto updatePostType(PostTypeDto postTypeDto);

    /**
     * Description: 删除博文类型
     *
     * @param type type
     * @return int
     */
    int deletePostType(String type);
}
