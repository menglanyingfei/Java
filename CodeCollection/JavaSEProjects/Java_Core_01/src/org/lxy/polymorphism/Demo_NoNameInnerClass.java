package org.lxy.polymorphism;
/**
 * @author menglanyingfei
 * @date 2017-2-15
 */
public class Demo_NoNameInnerClass {
	/**
	 * 匿名内部类的使用
	 * @param args
	 */
	public static void main(String[] args) {
		Outer.method().show(); // 链式编程
		System.out.println("================");
		Inter i = Outer.method();
		i.show();
	}
}

interface Inter {
	public abstract void show();
}

class Outer {
	public static Inter method() {
		return new Inter() {
			public void show() {
				System.out.println("HelloWorld");
			}
		};
	}
}















