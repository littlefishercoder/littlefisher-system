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
 * Description: UserController
 *  
 * Created on 2016年12月30日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 使用@Autowired能完成自动装配，也就是省略了get/set方法
     */
    @Autowired
    private IUserService userService;

    /**
     * 
     * Description:  listUser
     * 
     * @author jinyanan
     *
     * @param request request
     * @return String
     */
    @RequestMapping(value = "/listUser")
    public String listUser(HttpServletRequest request) {

        List<UserDto> list = userService.getAll();
        request.setAttribute("userlist", list);
        return "listUser";
    }

    /**
     * 
     * Description:  addUser
     * 
     * @author jinyanan
     *
     * @param muser muser
     * @return String
     */
    @RequestMapping(value = "/addUser")
    public String addUser(UserDto muser) {

        // String id = UUID.randomUUID().toString();
        // muser.setId(id);
        userService.insert(muser);
        return "redirect:/muserController/listUser.do";
    }

    /**
     * 
     * Description:  deleteUser
     * 
     * @author jinyanan
     *
     * @param id id
     * @return String
     */
    @RequestMapping(value = "/deleteUser")
    public String deleteUser(Long id) {

        userService.delete(id);
        return "redirect:/muserController/listUser.do";
    }

    /**
     * 
     * Description:  updateUserUI
     * 
     * @author jinyanan
     *
     * @param id id
     * @param request request
     * @return String
     */
    @RequestMapping(value = "/updateUserUI")
    public String updateUserUI(Long id, HttpServletRequest request) {

        UserDto muser = userService.selectByPrimaryKey(id);
        request.setAttribute("user", muser);
        return "updateUser";
    }

    /**
     * 
     * Description:  updateUser
     * 
     * @author jinyanan
     *
     * @param muser muser
     * @return String
     */
    @RequestMapping(value = "/updateUser")
    public String updateUser(UserDto muser) {

        userService.update(muser);
        return "redirect:/muserController/listUser.do";
    }
}
