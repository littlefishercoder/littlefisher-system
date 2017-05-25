package com.littlefisher.blog.post.service;

import java.util.List;

import com.littlefisher.blog.post.model.PostDto;
import com.littlefisher.blog.post.model.request.GetPostList4PagerByCondRequest;
import com.littlefisher.core.exception.BaseAppException;

/**
 * 
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
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param req req
     * @return List<PostDto>
     * @throws BaseAppException <br>
     */
    List<PostDto> getPostList4PagerByCond(GetPostList4PagerByCondRequest req) throws BaseAppException;
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param postId postId
     * @return PostDto
     * @throws BaseAppException <br>
     */
    PostDto getPostById(Long postId) throws BaseAppException;
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param postDto postDto
     * @return PostDto
     * @throws BaseAppException <br>
     */
    PostDto addPost(PostDto postDto) throws BaseAppException;
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param postDto postDto
     * @return PostDto
     * @throws BaseAppException <br>
     */
    PostDto updatePost(PostDto postDto) throws BaseAppException;
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param postId postId
     * @return int
     * @throws BaseAppException <br>
     */
    int deletePostById(Long postId) throws BaseAppException;
    
}
