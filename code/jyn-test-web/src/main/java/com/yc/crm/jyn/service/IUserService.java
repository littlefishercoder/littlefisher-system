package com.yc.crm.jyn.service;

import java.util.List;

import com.yc.crm.jyn.dto.UserDto;

public interface IUserService {

	List<UserDto> getAll();
	
	UserDto selectByPrimaryKey(Long id);
	
    int insert(UserDto muser);
    
    int update(UserDto muser);
    
    int delete(Long id);
}
