package com.littlefisher.blog.post.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;

/**
 * 
 * Description: 博文Controller
 *  
 * Created on 2017年5月22日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RestController
@RequestMapping("/api/blog/v1/posts")
@Api(value = "post", description = "post 接口API")
public class PostController {

}
