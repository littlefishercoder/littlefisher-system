package com.littlefisher.blog.biz.request;

import com.littlefisher.core.mybatis.pagehelper.PageParam;

import io.swagger.annotations.ApiModel;

/**
 * Description: GetTagList4PageByCondRequest.java
 *
 * Created on 2017年12月27日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("查询标签列表的入参条件，分页用")
public class GetTagList4PageByCondRequest extends PageParam {

    /** serialVersionUID */
    private static final long serialVersionUID = -8464817957236483817L;
}
