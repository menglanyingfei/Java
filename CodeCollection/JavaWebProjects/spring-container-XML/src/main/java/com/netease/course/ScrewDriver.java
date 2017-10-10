package com.netease.course;
/**
 * @author menglanyingfei
 * @date 2017-8-17
 */
public class ScrewDriver {
	private Header header;
	
//	public ScrewDriver(Header header) {
//		this.header = header;
//	}
	
	public void setHeader(Header header) {
		this.header = header;
	}
	
	public void use() {
		System.out.println("Use header: " + header.getInfo());
		header.doWork();
	}

}
