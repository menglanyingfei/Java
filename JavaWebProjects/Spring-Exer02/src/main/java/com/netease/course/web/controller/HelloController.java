package com.netease.course.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {
	
	@RequestMapping(value = "/spring")
	public void spring(HttpServletResponse response) throws IOException {
		System.out.println("spring Controller");
		response.getWriter().write("Hello, Spring Web!!");
	}
}
