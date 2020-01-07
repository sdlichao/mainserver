package com.demo.aspect;

public class StudentInterfaceImpl implements StudentInterface {

    @Override
    @OutInfo
    public void showGrade() {
        System.out.println("成绩为：100");
    }
}
