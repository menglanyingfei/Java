package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author menglanyingfei
 * @date 2017-9-11
 */

class Student implements Serializable {
	private static final long serialVersionUID = 4756345137386016055L;
	private String name;
	private int age;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return name + " " + age;
	}
	
}

public class SerializableTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Student s1 = new Student("John", 18);
			System.out.println(s1);
			
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("obj.dat"));
			out.writeObject(s1);
			out.close();
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream("obj.dat"));
			Student s2 = (Student) in.readObject();
			System.out.println(s2);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
