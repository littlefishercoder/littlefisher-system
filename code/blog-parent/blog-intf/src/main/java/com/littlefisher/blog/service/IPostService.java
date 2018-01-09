package com.littlefisher.blog.service;

import java.util.List;

import com.littlefisher.blog.model.PostDto;
import com.littlefisher.blog.model.ext.PostExtDto;
import com.littlefisher.blog.request.AddPostRequest;
import com.littlefisher.blog.request.GetPostList4PagerByCondRequest;

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
    List<PostExtDto> getPostList4PagerByCond(GetPostList4PagerByCondRequest req);

    /**
     * Description:
     *
     * @param postId postId
     * @return PostDto
     */
    PostDto getPostById(Long postId);

    /**
     * 根据id查询博文，不带博文全文
     * @param postId 博文id
     * @return 博文实体
     */
    PostDto getPostWithoutBlobById(Long postId);

    /**
     * Description: 新增博文
     *
     * @param request request
     */
    void addPost(AddPostRequest request);

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
