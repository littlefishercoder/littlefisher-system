package com.littlefisher.blog.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.cmd.tag.GetTagList4PagerByCondCommand;
import com.littlefisher.blog.model.TagDto;
import com.littlefisher.blog.request.GetTagList4PagerByCondRequest;
import com.littlefisher.blog.service.ITagService;
import com.littlefisher.core.interceptor.service.ServiceImpl;

/**
 * Description: TagServiceImpl.java
 *
 * Created on 2017年12月27日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Service
public class TagServiceImpl extends ServiceImpl implements ITagService {

    @Override
    public List<TagDto> getTagList4PagerByCond(GetTagList4PagerByCondRequest request) {
        return execute(new GetTagList4PagerByCondCommand(request));
    }
}
