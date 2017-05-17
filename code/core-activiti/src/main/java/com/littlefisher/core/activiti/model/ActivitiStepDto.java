package com.littlefisher.core.activiti.model;

/**
 * 
 * Description: 流程步骤
 *  
 * Created on 2017年4月18日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class ActivitiStepDto implements Comparable<ActivitiStepDto> {
    
    /**
     * 状态
     */
    private String orderState;
    
    /**
     * 环节名称
     */
    private String taskName;
    
    /**
     * 环节类型
     */
    private String taskType;
    
    /**
     * 排序
     */
    private Long orderNbr;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ActivitiStepDto [orderState=");
        builder.append(orderState);
        builder.append(", taskName=");
        builder.append(taskName);
        builder.append(", taskType=");
        builder.append(taskType);
        builder.append(", orderNbr=");
        builder.append(orderNbr);
        builder.append("]");
        return builder.toString();
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public Long getOrderNbr() {
        return orderNbr;
    }

    public void setOrderNbr(Long orderNbr) {
        this.orderNbr = orderNbr;
    }

    @Override
    public int compareTo(ActivitiStepDto o) {
        return (int) (this.orderNbr - o.orderNbr);
    }
}
