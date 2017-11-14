package com.littlefisher.blog.post.cmd;

import com.littlefisher.blog.post.dao.PostTypeDtoMapper;
import com.littlefisher.blog.post.model.PostTypeDto;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
 * Description:
 *
 * Created on 2017年5月25日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class UpdatePostTypeCmd extends AbstractCommand<PostTypeDto> {

    /**
     * postTypeDto
     */
    private PostTypeDto postTypeDto;

    /**
     * Description: 构造函数
     *
     * @param postTypeDto postTypeDto
     */
    public UpdatePostTypeCmd(PostTypeDto postTypeDto) {
        super();
        this.postTypeDto = postTypeDto;
    }

    @Override
    public PostTypeDto execute() {
        PostTypeDtoMapper postTypeDtoMapper = this.getMapper(PostTypeDtoMapper.class);
        postTypeDtoMapper.updateByPrimaryKey(postTypeDto);
        return postTypeDto;
    }

}
