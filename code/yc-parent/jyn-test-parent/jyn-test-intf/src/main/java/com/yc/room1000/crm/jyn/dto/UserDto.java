package com.yc.room1000.crm.jyn.dto;

import java.io.Serializable;

/**
 * 
 * Description: UserDto
 *  
 * Created on 2017年1月3日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class UserDto implements Serializable {
    
    /**
     * serialVersionUID 
     */
    private static final long serialVersionUID = 583951193929087111L;

    /** id */
    private Long id;

    /** mobile */
    private String mobile;

    /** password */
    private String password;

    /** type */
    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}