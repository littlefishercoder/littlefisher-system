package com.littlefisher.blog.intf.post;

import java.util.List;

import com.littlefisher.blog.model.post.PostStateDto;

/**
 * Description:
 *
 * Created on 2017年5月25日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IPostStateService {

    /**
     * Description: 查询所有博文状态
     *
     * @return List<PostStateDto>
     */
    List<PostStateDto> getAllPostState();

    /**
     * Description: 新增博文状态
     *
     * @param postStateDto postStateDto
     * @return PostStateDto
     */
    PostStateDto addPostState(PostStateDto postStateDto);

    /**
     * Description: 修改博文状态
     *
     * @param postStateDto postStateDto
     * @return PostStateDto
     */
    PostStateDto updatePostState(PostStateDto postStateDto);

    /**
     * Description: 删除博文状态
     *
     * @param state state
     * @return int
     */
    int deletePostState(String state);
}
