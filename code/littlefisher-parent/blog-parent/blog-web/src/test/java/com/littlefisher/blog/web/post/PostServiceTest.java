package com.littlefisher.blog.web.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.littlefisher.blog.biz.model.PostBizDto;
import com.littlefisher.blog.biz.model.PostBizExtDto;
import com.littlefisher.blog.biz.request.GetPostList4PageByCondRequest;
import com.littlefisher.blog.biz.service.IPostService;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.utils.LittleFisherLogger;

/**
 * Description: PostServiceTest.java
 *
 * Created on 2017年12月04日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

    private LittleFisherLogger logger = LittleFisherLogger.getLogger(PostServiceTest.class);

    @Autowired
    private IPostService postService;

    @Test
    public void testGetPostList4PagerByCond() {
        GetPostList4PageByCondRequest req = new GetPostList4PageByCondRequest();
        req.setPageNum(1);
        req.setPageSize(20);
        PageInfo<PostBizExtDto> postList = postService.getPostList4PageByCond(req);
        logger.debug("postList: [{}]", postList);
    }

    @Test
    public void testGetPostWithoutBlobById() {
        Long postId = 1L;
        PostBizDto postDto = postService.getPostWithoutBlobById(postId);

        logger.debug("postDto: [{}]", postDto);
    }

}
