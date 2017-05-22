package com.littlefisher.blog.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;


/**
 *
 * Description: user_role 实体
 *
 * Created on 2017年05月22日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "user_role")
@ApiModel(value = "user_role实体")
public class UserRoleDto implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户主键
     */
    @ApiModelProperty(value = "用户主键")
    @Column(name = "user_id")
    private Long userId;

    /**
     * 角色主键
     */
    @ApiModelProperty(value = "角色主键")
    @Column(name = "role_id")
    private Long roleId;

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", roleId=").append(roleId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}