package org.lxy.javase_2;
/**
 * @author menglanyingfei
 * @date 2017-3-9
 */
public class Student2 {
	private String name;
	private int age;
	
	public Student2() {}
	public Student2(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	/**
     * 重写equals()方法
     */
    public boolean equals(Object object) {
        if(object instanceof Student2) {
        	Student2 s = (Student2) object;
            return this.getName() == s.getName() && this.getAge() == s.getAge();
        }
        return false;
    }
}
