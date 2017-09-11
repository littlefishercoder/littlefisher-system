/**
 * hsjry.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.littlefisher.blog.post.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.littlefisher.blog.post.model.PostDto;
import com.littlefisher.blog.post.model.request.GetPostList4PagerByCondRequest;
import com.littlefisher.core.spring.config.RootConfig;
import com.littlefisher.core.utils.LittleFisherLogger;

/**
 * @author jinyn22648
 * @version $Id: TestPostService.java, v 1.0 2017-09-07 20:18 jinyn22648 Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
@Transactional
@Rollback
public class TestPostService {

    private static LittleFisherLogger logger = LittleFisherLogger.getLogger(TestPostService.class);

    @Autowired
    private IPostService postService;

    @Test
    public void testGetPostList4PagerByCond() {
        GetPostList4PagerByCondRequest request = new GetPostList4PagerByCondRequest();
        request.setPageNum(4);
        request.setPageSize(5);
        List<PostDto> postList = postService.getPostList4PagerByCond(request);
        logger.info("postList: " + postList);
    }

}
