package com.wtu.entity;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.13 11:29
 */
public class Student {
    private String name;
    private String age;
    private String sex;
    private Double score;

    public Student() {
    }

    public Student(String name, String age, String sex, Double score) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.score = score;
    }

    public String getName2() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
