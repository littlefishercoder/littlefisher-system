package com.yc.room1000.engine.attr.model;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *
 * Description: attr_state实体
 *
 * Created on 2017年03月01日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel(value = "attr_state实体")
public class AttrStateDto implements Serializable {
    /**
     * state 状态
     */
    @ApiModelProperty(value = "状态")
    private String state;

    /**
     * stateName 状态名称
     */
    @ApiModelProperty(value = "状态名称")
    private String stateName;

    /**
     * stateNameEn 英文状态名称
     */
    @ApiModelProperty(value = "英文状态名称")
    private String stateNameEn;

    /**
     * comments 备注
     */
    @ApiModelProperty(value = "备注")
    private String comments;

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName == null ? null : stateName.trim();
    }

    public String getStateNameEn() {
        return stateNameEn;
    }

    public void setStateNameEn(String stateNameEn) {
        this.stateNameEn = stateNameEn == null ? null : stateNameEn.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    /**
     * Description: toString<br>
     *
     * @author jinyanan <br>
    
     * @return String String<br>
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", state=").append(state);
        sb.append(", stateName=").append(stateName);
        sb.append(", stateNameEn=").append(stateNameEn);
        sb.append(", comments=").append(comments);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}