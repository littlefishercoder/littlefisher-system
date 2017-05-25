package com.littlefisher.blog.post.service;

import java.util.List;

import com.littlefisher.blog.post.model.PostTypeDto;
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
public interface IPostTypeService {

    /**
     * 
     * Description: 查询所有博文类型
     * 
     * @author jinyanan
     *
     * @return List<PostTypeDto>
     * @throws BaseAppException <br>
     */
    List<PostTypeDto> getAllPostType() throws BaseAppException;

    /**
     * 
     * Description: 新增博文类型
     * 
     * @author jinyanan
     *
     * @param postTypeDto postTypeDto
     * @return PostTypeDto
     * @throws BaseAppException <br>
     */
    PostTypeDto addPostType(PostTypeDto postTypeDto) throws BaseAppException;

    /**
     * 
     * Description: 修改博文类型
     * 
     * @author jinyanan
     *
     * @param postTypeDto postTypeDto
     * @return PostTypeDto
     * @throws BaseAppException <br>
     */
    PostTypeDto updatePostType(PostTypeDto postTypeDto) throws BaseAppException;
    
    /**
     * 
     * Description: 删除博文类型
     * 
     * @author jinyanan
     *
     * @param type type
     * @return int
     * @throws BaseAppException <br>
     */
    int deletePostType(String type) throws BaseAppException;
}
