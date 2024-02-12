package com.jdbc;
public class Student {

    String full_names;
    int age;
    String school;


    public Student(String full_names, int age, String school) {
        this.full_names = full_names;
        this.age = age;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student [full_names=" + full_names + ", age=" + age + ", school=" + school + "]";
    }

}
