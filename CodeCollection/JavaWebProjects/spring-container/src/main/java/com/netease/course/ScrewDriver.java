package com.netease.course;
/**
 * @author menglanyingfei
 * @date 2017-8-16
 */
public class ScrewDriver {
	private String color = "red";
	
	public void use() {
		System.out.println("Use " + color + " screwdriver");
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void init() {
		System.out.println("Init screwdriver");
	}
	
	public void cleanup() {
		System.out.println("Cleanup screwdriver");
	}
}
