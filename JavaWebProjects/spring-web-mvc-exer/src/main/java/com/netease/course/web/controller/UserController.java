package com.netease.course.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.netease.course.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	
	// 使用HTML时标题中文有乱码!!!
	@RequestMapping("/userList")
	public ModelAndView getUserList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("userList");
		mav.addObject("userList", userService.getUserList());
		return mav;
	}
}
