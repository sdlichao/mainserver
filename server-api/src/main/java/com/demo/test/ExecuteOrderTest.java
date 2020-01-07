package com.demo.test;

public class ExecuteOrderTest {

    {
        System.out.println("执行代码块！！！");
    }

    static {
        System.out.println("执行静态代码块！！！");
    }

    public ExecuteOrderTest() {
        System.out.println("执行构造函数！！！");
    }

    public static void main(String[] args) {
        ExecuteOrderTest eot = new ExecuteOrderTest();

    }
}
