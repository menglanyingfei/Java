package com.lxy.enumtest;

public class Demo {
	
}

enum Color {
	RED("红色") {
		@Override
		public void run2() {
			
		}	
	}, GREEN("红色") {
		@Override
		public void run2() {
			
		}	
	}, BLUE("红色") {
		@Override
		public void run2() {
			
		}	
	};
			
	private Color(String name) {
		System.out.println(name);
	}
	
	public void run() {
		
	}
	
	public abstract void run2();
}




