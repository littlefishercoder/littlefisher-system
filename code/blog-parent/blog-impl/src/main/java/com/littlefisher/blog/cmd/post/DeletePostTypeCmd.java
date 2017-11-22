package com.littlefisher.blog.cmd.post;

import com.littlefisher.blog.dao.post.PostTypeDtoMapper;
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
public class DeletePostTypeCmd extends AbstractCommand<Integer> {

    /**
     * type
     */
    private String type;

    /**
     * Description: 构造函数
     *
     * @param type type
     */
    public DeletePostTypeCmd(String type) {
        super();
        this.type = type;
    }

    @Override
    public Integer execute() {
        PostTypeDtoMapper postTypeDtoMapper = this.getMapper(PostTypeDtoMapper.class);
        return postTypeDtoMapper.deleteByPrimaryKey(type);
    }

}
