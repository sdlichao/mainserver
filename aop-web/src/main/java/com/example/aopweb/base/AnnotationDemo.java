package com.example.aopweb.base;

import com.alibaba.fastjson.JSON;
import com.example.aopweb.aspect.StudentInterface;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;

public class AnnotationDemo {

    public static void main(String[] args) {

        getAnnotationImpl();

        /*Annotation[] annotations = stu.getAnnotations();

        for (Annotation ann : annotations){
            System.out.println(JSON.toJSONString(ann));
        }*/

    }

    /**
     * 获取接口的注解
     */
    public static void getAnnotationInterface(){
        Class stu = StudentInterface.class;
        Method[] methods = stu.getMethods();

        for(Method method : methods){
            Annotation[] annotations = method.getAnnotations();
            Annotation[] declaredAnnotations = method.getDeclaredAnnotations();

            System.out.println("annotations="+JSON.toJSONString(annotations));
            System.out.println("declaredAnnotations="+JSON.toJSONString(declaredAnnotations));

            System.out.println("====================");
        }
    }

    /**
     * 获取实现类接口的注解
     */
    public static void getAnnotationImpl(){
        Class<StudentInterfaceImpl> studentInterfaceClass = StudentInterfaceImpl.class;
        Method[] methods = studentInterfaceClass.getMethods();

        Class<? super StudentInterfaceImpl> superclass = studentInterfaceClass.getSuperclass();


        Class<?>[] interfaces = studentInterfaceClass.getInterfaces();
        AnnotatedType[] annotatedInterfaces = studentInterfaceClass.getAnnotatedInterfaces();
        studentInterfaceClass.getGenericInterfaces();

        for (Class aClass : interfaces) {
            Method[] aClassMethods = aClass.getMethods();
            Annotation[] declaredAnnotations = aClassMethods[0].getDeclaredAnnotations();
            System.out.println(JSON.toJSONString(aClass));
        }

        for (AnnotatedType annotatedType : annotatedInterfaces) {
            System.out.println(JSON.toJSONString(annotatedType));
        }

    }
}
