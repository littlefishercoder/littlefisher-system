package com.littlefisher.blog.post.service;

import java.util.List;

import com.littlefisher.blog.post.model.PostStateDto;
import com.littlefisher.core.exception.BaseAppException;

/**
 * 
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
     * 
     * Description: 查询所有博文状态
     * 
     * @author jinyanan
     *
     * @return List<PostStateDto>
     * @throws BaseAppException <br>
     */
    List<PostStateDto> getAllPostState() throws BaseAppException;

    /**
     * 
     * Description: 新增博文状态
     * 
     * @author jinyanan
     *
     * @param postStateDto postStateDto
     * @return PostStateDto
     * @throws BaseAppException <br>
     */
    PostStateDto addPostState(PostStateDto postStateDto) throws BaseAppException;

    /**
     * 
     * Description: 修改博文状态
     * 
     * @author jinyanan
     *
     * @param postStateDto postStateDto
     * @return PostStateDto
     * @throws BaseAppException <br>
     */
    PostStateDto updatePostState(PostStateDto postStateDto) throws BaseAppException;
    
    /**
     * 
     * Description: 删除博文状态
     * 
     * @author jinyanan
     *
     * @param state state
     * @return int
     * @throws BaseAppException <br>
     */
    int deletePostState(String state) throws BaseAppException;
}
