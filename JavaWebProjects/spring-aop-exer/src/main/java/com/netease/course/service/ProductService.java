package com.netease.course.service;

import org.springframework.stereotype.Component;

/**
 * @author menglanyingfei
 * @date 2017-8-26
 */

@Component
public class ProductService {

	public void add(String string) {
		System.out.println("add method...");
	}
	public void del(String string) {
		System.out.println("param string = " + string);
		System.out.println("del method...");
	}
	public void change(String string) {
		System.out.println("change method...");
	}
	public void select(String string) {
		System.out.println("select method...");
	}

}
