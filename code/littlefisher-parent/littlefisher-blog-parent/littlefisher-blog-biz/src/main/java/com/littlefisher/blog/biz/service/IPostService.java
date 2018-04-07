package com.littlefisher.blog.biz.service;

import com.littlefisher.blog.biz.model.PostBizDto;
import com.littlefisher.blog.biz.model.PostBizExtDto;
import com.littlefisher.blog.biz.request.AddPostRequest;
import com.littlefisher.blog.biz.request.GetPostList4PageByCondRequest;
import com.littlefisher.blog.biz.request.UpdatePostRequest;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;

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
    PageInfo<PostBizExtDto> getPostList4PageByCond(GetPostList4PageByCondRequest req);

    /**
     * Description:
     *
     * @param postId postId
     * @return PostDto
     */
    PostBizDto getPostById(Long postId);

    /**
     * 根据id查询博文，不带博文全文
     * @param postId 博文id
     * @return 博文实体
     */
    PostBizDto getPostWithoutBlobById(Long postId);

    /**
     * Description: 新增博文
     *
     * @param request request
     */
    void addPost(AddPostRequest request);

    /**
     * Description:
     *
     * @param request postDto
     * @return PostDto
     */
    PostBizDto updatePost(UpdatePostRequest request);

    /**
     * Description:
     *
     * @param postId postId
     * @return int
     */
    int deletePostById(Long postId);

}
