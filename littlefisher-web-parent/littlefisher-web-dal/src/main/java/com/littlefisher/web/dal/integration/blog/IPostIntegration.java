package com.littlefisher.web.dal.integration.blog;

import com.littlefisher.blog.biz.model.PostBizDto;
import com.littlefisher.blog.biz.model.PostBizExtDto;
import com.littlefisher.blog.biz.request.AddPostRequest;
import com.littlefisher.blog.biz.request.GetPostList4PageByCondRequest;
import com.littlefisher.blog.biz.request.UpdatePostRequest;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;

/**
 * Description: IPostIntegration.java
 *
 * Created on 2018年03月31日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IPostIntegration {

    /**
     * 根据条件分页查询博文列表
     * 
     * @param req req
     * @return 博文列表
     */
    PageInfo<PostBizExtDto> getPostList4PageByCond(GetPostList4PageByCondRequest req);

    /**
     * 根据博文id查询博文
     * 
     * @param postId postId
     * @return PostDto
     */
    PostBizDto getPostById(Long postId);

    /**
     * 根据id查询博文，不带博文全文
     * 
     * @param postId 博文id
     * @return 博文实体
     */
    PostBizDto getPostWithoutBlobById(Long postId);

    /**
     * 新增博文
     *
     * @param request request
     */
    void addPost(AddPostRequest request);

    /**
     * 更新博文
     * 
     * @param request postDto
     * @return PostDto
     */
    PostBizDto updatePost(UpdatePostRequest request);

    /**
     * 删除博文
     * 
     * @param postId postId
     * @return int
     */
    int deletePostById(Long postId);
}
