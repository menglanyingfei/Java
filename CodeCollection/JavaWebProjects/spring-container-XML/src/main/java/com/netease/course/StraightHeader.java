package com.netease.course;

//import java.util.Properties;

/**
 * @author menglanyingfei
 * @date 2017-8-17
 */
public class StraightHeader implements Header {
	private String color;
	private int size;

	public void setColor(String color) {
		this.color = color;
	}
	
//	public StraightHeader(String color, int size) {
//		this.color = color;
//		this.size = size;
//	}

	/*
	public StraightHeader(Map<String, String> paras) {
		this.color = paras.get("color");
		this.size = Integer.valueOf(paras.get("size"));
	}
	*/
	
//	public StraightHeader(Properties properties) {
//		this.color = properties.getProperty("color");
//		this.size = Integer.valueOf(properties.getProperty("size"));
//	}
	
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public void doWork() {
		System.out.println("Do work with straight header");
	}

	@Override
	public String getInfo() {
		return "StraightHeader: color=" + color + ", size=" + size;
	}

}
