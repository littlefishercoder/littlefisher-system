package com.littlefisher.user.biz.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.sf.oval.constraint.NotNull;

/**
 * Description: GetResourceRequest.java
 *
 * Created on 2018年02月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("查询Resource请求")
public class GetResourceRequest implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -2904028821745421517L;

    /** 方言 */
    @ApiModelProperty(required = true, value = "方言，可选zh、en")
    @NotNull(message = "方言不可为空")
    private String dialect;

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    @Override
    public String toString() {
        return "GetResourceRequest{" + "dialect='" + dialect + '\'' + '}';
    }
}
