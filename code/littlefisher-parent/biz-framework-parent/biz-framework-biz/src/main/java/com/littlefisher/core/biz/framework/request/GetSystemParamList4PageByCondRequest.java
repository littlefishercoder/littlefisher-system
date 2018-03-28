package com.littlefisher.core.biz.framework.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.littlefisher.core.mybatis.pagehelper.PageParam;

/**
 * Description: 查询系统参数列表条件
 *
 * Created on 2017年5月22日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("查询系统参数列表的入参条件，分页用")
public class GetSystemParamList4PageByCondRequest extends PageParam {

    /**
     * id 主键id
     */
    @ApiModelProperty("主键id")
    private Long id;

    /**
     * paramKey 参数key 模糊查询
     */
    @ApiModelProperty("参数key")
    private String paramKey;

    /**
     * paramValue 参数value 模糊查询
     */
    @ApiModelProperty("参数value")
    private String paramValue;

    /**
     * defaultValue 参数默认value 模糊查询
     */
    @ApiModelProperty("参数默认value")
    private String defaultValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public String toString() {
        return "GetSystemParamList4PageByCondRequest{" + "id=" + id + ", paramKey='" + paramKey + '\'' +
                ", paramValue='" + paramValue + '\'' + ", defaultValue='" + defaultValue + '\'' + "} " +
                super.toString();
    }
}
