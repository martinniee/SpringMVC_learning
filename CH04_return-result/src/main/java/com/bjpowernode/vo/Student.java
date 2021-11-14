package com.bjpowernode.vo;

/**
 * @author nathan
 * @create 2021-11-11-13:27
 */
public class Student {

    // 1、定义属性,作为方法的形参,应该和请求的实参一致
    private String name;
    private Integer age;

    // 2、设置无参构造和对应属性的set,get方法


    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
