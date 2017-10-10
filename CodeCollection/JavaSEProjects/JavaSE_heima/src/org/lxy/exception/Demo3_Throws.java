package org.lxy.exception;
/**
 * @author menglanyingfei
 * @date 2017-3-23
 */
public class Demo3_Throws {

	/**
	 * @param args
	 * @throws AgeOutOfBoundsException 
	 * @throws Exception 
	 */
	public static void main(String[] args) throws AgeOutOfBoundsException {
		Person p = new Person();
		p.setAge(-12);
		System.out.println(p.getAge());
	}

}

class Person {
	private int age;
	private String name;
	
	public Person() {
		super();
		
	}
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws AgeOutOfBoundsException {
		if (age > 0 && age <= 150) {
			this.age = age;
		} else {
//			throw new RuntimeException("参数非法");
			throw new AgeOutOfBoundsException("参数非法");
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}



















