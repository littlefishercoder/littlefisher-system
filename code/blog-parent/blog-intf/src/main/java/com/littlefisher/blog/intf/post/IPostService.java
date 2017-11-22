package com.littlefisher.blog.intf.post;

import java.util.List;

import com.littlefisher.blog.model.post.PostDto;
import com.littlefisher.blog.request.post.GetPostList4PagerByCondRequest;

/**
 * Description: 博文接口
 *
 * Created on 2017年5月22日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IPostService {

    /**
     * Description:
     *
     * @param req req
     * @return List<PostDto>
     */
    List<PostDto> getPostList4PagerByCond(GetPostList4PagerByCondRequest req);

    /**
     * Description:
     *
     * @param postId postId
     * @return PostDto
     */
    PostDto getPostById(Long postId);

    /**
     * Description:
     *
     * @param postDto postDto
     * @return PostDto
     */
    PostDto addPost(PostDto postDto);

    /**
     * Description:
     *
     * @param postDto postDto
     * @return PostDto
     */
    PostDto updatePost(PostDto postDto);

    /**
     * Description:
     *
     * @param postId postId
     * @return int
     */
    int deletePostById(Long postId);

}
