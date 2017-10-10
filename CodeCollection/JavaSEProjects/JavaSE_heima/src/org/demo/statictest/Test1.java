package org.demo.statictest;
/**
 * @author menglanyingfei
 * @date 2017-5-14
 */
public class Test1 {
    Person person = new Person("Test1");
    static{
        System.out.println("test1 static");
    }
     
    public Test1() {
        System.out.println("test1 constructor");
    }
     
    public static void main(String[] args) {
        new MyClass();
//        test1 static
//        myclass static
//        person static
//        person Test1
//        test1 constructor
//        person MyClass
//        myclass constructor
    }
}
 
class Person{
    static{
        System.out.println("person static");
    }
    public Person(String str) {
        System.out.println("person "+str);
    }
}
 
 
class MyClass extends Test1 {
    Person person = new Person("MyClass");
    static{
        System.out.println("myclass static");
    }
     
    public MyClass() {
        System.out.println("myclass constructor");
    }
}
