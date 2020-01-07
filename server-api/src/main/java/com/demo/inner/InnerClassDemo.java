package com.demo.inner;

public class InnerClassDemo {

    public static void main(String[] args) {
        InnerClassDemo ftd = new InnerClassDemo();
        InnerDemo innerDemo = new InnerClassDemo.InnerDemo();
        innerDemo.save();

        InnerDemo1 innerDemo1 = ftd.new InnerDemo1();
        innerDemo1.update();

        InnerDemo2 innerDemo2=new InnerDemo2();
        innerDemo2.delete();

    }

    public void demo(){
        InnerDemo innerDemo = new InnerDemo();
        innerDemo.save();
    }

    static class InnerDemo{
        public void save() {
            System.out.println("123123123");
        }
    }

    class InnerDemo1{
        public void update(){
            System.out.println("update is success!!!");
        }
    }
}

class InnerDemo2{
    public void delete(){
        System.out.println("delete is success!!!");
    }
}



