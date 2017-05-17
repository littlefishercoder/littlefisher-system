package com.littlefisher.blog.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;


/**
 *
 * Description: USER_STATE 实体
 *
 * Created on 2017年05月17日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "USER_STATE")
@ApiModel(value = "USER_STATE实体")
public class UserStateDto implements Serializable {
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @Id
    @Column(name = "STATE")
    private String state;

    /**
     * 状态名
     */
    @ApiModelProperty(value = "状态名")
    @Column(name = "STATE_NAME")
    private String stateName;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @Column(name = "COMMENTS")
    private String comments;

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Description: toString<br>
     *
     * @author autoCreated <br>
    
     * @return String String<br>
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", state=").append(state);
        sb.append(", stateName=").append(stateName);
        sb.append(", comments=").append(comments);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}