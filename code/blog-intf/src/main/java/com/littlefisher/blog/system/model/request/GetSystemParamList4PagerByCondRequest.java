package com.littlefisher.blog.system.model.request;

import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 
 * Description: 查询系统参数列表条件
 *  
 * Created on 2017年5月22日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class GetSystemParamList4PagerByCondRequest {

    /**
     * pageNum 页码
     */
    @ApiModelProperty(value = "页码")
    private int pageNum;
    
    /**
     * pageSize 每页行数
     */
    @ApiModelProperty(value = "每页行数")
    private int pageSize;
    
    /**
     * id 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Long id;
    
    /**
     * paramKey 参数key
     */
    @ApiModelProperty(value = "参数key")
    private String paramKey;
    
    /**
     * paramValue 参数value
     */
    @ApiModelProperty(value = "参数value")
    private String paramValue;
    
    /**
     * defaultValue 参数默认value
     */
    @ApiModelProperty(value = "参数默认value")
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
        StringBuilder builder = new StringBuilder();
        builder.append("GetSystemParamList4PagerByCondRequest [pageNum=");
        builder.append(pageNum);
        builder.append(", pageSize=");
        builder.append(pageSize);
        builder.append(", id=");
        builder.append(id);
        builder.append(", paramKey=");
        builder.append(paramKey);
        builder.append(", paramValue=");
        builder.append(paramValue);
        builder.append(", defaultValue=");
        builder.append(defaultValue);
        builder.append("]");
        return builder.toString();
    }
    
    
}
