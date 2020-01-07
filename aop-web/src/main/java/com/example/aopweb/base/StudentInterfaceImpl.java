package com.example.aopweb.base;

import com.example.aopweb.aspect.StudentInterface;
import org.springframework.stereotype.Service;

@Service
public class StudentInterfaceImpl implements StudentInterface {

    @Override
//    @OutInfo
    public void showGrade() {
        System.out.println("成绩为：100");
    }
}
