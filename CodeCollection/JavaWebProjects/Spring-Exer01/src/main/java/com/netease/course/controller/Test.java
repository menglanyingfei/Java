package com.netease.course.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/into")
public class Test {
	@RequestMapping("/blogger")
	@ResponseBody
	public String update(@RequestParam String blogTitle,
			@RequestParam String blogContent, HttpServletResponse resp) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"application-context.xml");
		BlogService blogservice = context.getBean("blogservice",
				BlogService.class);

		if (blogTitle.length() < 21 && blogContent.length() < 101
				&& blogTitle.length() > 0 && blogContent.length() > 0) {
			blogservice.pressblog(blogTitle, blogContent);
			System.out.println("blog insert success");
			resp.setStatus(200);
			return "200, ok.blog insert success.<br />";
		} else {
			System.out.println("blog config is inlegal.");
			((ConfigurableApplicationContext) context).close();
			resp.setStatus(400);
			return "blog insert failed.<br>Check the size of Title or Content.<br><h2>BlogTitle:<br>"
					+ blogTitle + "</h2>";
		}

	}

}
