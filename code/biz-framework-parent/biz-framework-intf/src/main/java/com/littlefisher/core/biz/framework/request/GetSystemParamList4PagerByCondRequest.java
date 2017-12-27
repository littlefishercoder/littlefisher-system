package com.littlefisher.core.biz.framework.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
public class GetSystemParamList4PagerByCondRequest {

    /**
     * pageNum 页码
     */
    @ApiModelProperty("页码")
    private int pageNum;

    /**
     * pageSize 每页行数
     */
    @ApiModelProperty("每页行数")
    private int pageSize;

    /**
     * id 主键id
     */
    @ApiModelProperty("主键id")
    private Long id;

    /**
     * paramKey 参数key
     */
    @ApiModelProperty("参数key")
    private String paramKey;

    /**
     * paramValue 参数value
     */
    @ApiModelProperty("参数value")
    private String paramValue;

    /**
     * defaultValue 参数默认value
     */
    @ApiModelProperty("参数默认value")
    private String defaultValue;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

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
        final StringBuilder sb = new StringBuilder("GetSystemParamList4PagerByCondRequest{");
        sb.append("pageNum=").append(pageNum);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", id=").append(id);
        sb.append(", paramKey='").append(paramKey).append('\'');
        sb.append(", paramValue='").append(paramValue).append('\'');
        sb.append(", defaultValue='").append(defaultValue).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
