package com.yc.crm.jyn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yc.crm.jyn.dto.UserDto;
import com.yc.crm.jyn.service.IUserService;

/**
 * 
 * 使用@Controller说明该类是一个控制器
 * 
 * 使用@RequestMapping说明是为了组装请求url，
 * 例如类上是@RequestMapping("/muserController")，
 * 表明请求如果是以"/muserController*"的形式的话，进入该类中
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	/**
	 * 使用@Autowired能完成自动装配，也就是省略了get/set方法
	 */
	@Autowired
	private IUserService muserService;

	/**
	 * 
	 * 使用@RequestMapping说明是为了组装请求url，
	 * 例如方法上是@RequestMapping(value="/listUser")，
	 * 表明请求如果是以"/listUser"的形式的话，执行该方法
	 * PS：由于类上也定义了该注解，所以如果想请求进入该方法，请求的url需要是"/muserController/listUser"
	 */
	@RequestMapping(value="/listUser")
	public String listUser(HttpServletRequest request) {
		
		List <UserDto> list = muserService.getAll();
		request.setAttribute("userlist", list);
		return "listUser";
	}
	
	@RequestMapping(value="/addUser")
	public String addUser(UserDto muser) {
			
//		String id = UUID.randomUUID().toString();
//		muser.setId(id);
		muserService.insert(muser);
		return "redirect:/muserController/listUser.do";
	}
	
	@RequestMapping(value="/deleteUser")
	public String deleteUser(Long id) {
		
		muserService.delete(id);
		return "redirect:/muserController/listUser.do";
	}
	
	@RequestMapping(value="/updateUserUI")
	public String updateUserUI(Long id, HttpServletRequest request) {
		
		UserDto muser = muserService.selectByPrimaryKey(id);
		request.setAttribute("user", muser);
		return "updateUser";
	}

	@RequestMapping(value="/updateUser")
	public String updateUser(UserDto muser) {
		
		muserService.update(muser);
		return "redirect:/muserController/listUser.do";
	}
}
