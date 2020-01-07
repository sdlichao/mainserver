package com.example.aopweb;

import com.example.aopweb.aspect.StudentInterface;
import com.example.aopweb.base.StudentInterfaceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AopWebApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(AopWebApplication.class, args);

        StudentInterface studentInterface = applicationContext.getBean(StudentInterfaceImpl.class);
        studentInterface.showGrade();

    }

}
