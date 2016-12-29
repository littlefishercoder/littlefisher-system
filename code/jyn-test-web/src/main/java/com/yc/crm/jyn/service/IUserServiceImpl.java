package com.yc.crm.jyn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.crm.jyn.dao.UserDtoMapper;
import com.yc.crm.jyn.dto.UserDto;

@Service("muserService")
public class IUserServiceImpl implements IUserService{
	
	@Autowired
	private UserDtoMapper userDtoMapper;
	
	@Override
	public List<UserDto> getAll() {
		
		return userDtoMapper.getAll();
	}

	@Override
	public int insert(UserDto muser) {
		
		return userDtoMapper.insert(muser);
	}

	@Override
	public int update(UserDto muser) {
		
		return userDtoMapper.updateByPrimaryKey(muser);
	}

	@Override
	public int delete(Long id) {
	
		return userDtoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public UserDto selectByPrimaryKey(Long id) {
		
		return userDtoMapper.selectByPrimaryKey(id);
	}

}
