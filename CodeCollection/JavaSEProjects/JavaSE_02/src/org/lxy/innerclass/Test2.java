package org.lxy.innerclass;

/**
 * @author menglanyingfei
 * @date 2017-5-25
 */
class Bar {
	void doStuff(Foo f) {
		f.foo();
	}
}

interface Foo {
	void foo();
}

public class Test2 {
	static void go() {
		Bar b = new Bar();
		// 参数式的匿名内部类
		b.doStuff(new Foo() {
			public void foo() {
				System.out.println("foo");
			}
		});
	}
	public static void main(String[] args) {
		
	}
}
