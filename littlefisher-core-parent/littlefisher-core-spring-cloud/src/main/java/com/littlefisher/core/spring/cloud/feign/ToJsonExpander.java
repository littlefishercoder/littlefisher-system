package com.littlefisher.core.spring.cloud.feign;

import com.littlefisher.core.common.utils.GsonUtil;

import feign.Param;

/**
 *
 * @author jinyn22648
 * @version $$Id: ToJsonExpander.java, v 0.1 2018/6/28 下午6:47 jinyn22648 Exp $$
 */
public class ToJsonExpander implements Param.Expander {

    @Override
    public String expand(Object value) {
        return GsonUtil.obj2Json(value);
    }
}