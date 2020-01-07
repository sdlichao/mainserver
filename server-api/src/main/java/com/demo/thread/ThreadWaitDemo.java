package com.demo.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThreadWaitDemo {

    private static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new WaitDemo());

        t1.start();

        waitObject(object);
        waitObject(object);

        System.out.println("t1 is sleep !!!");
    }

    public static void waitObject (Object object) throws InterruptedException {
        synchronized (object){

            System.out.println("进入waitObject方法！！！" + new Date());
            object.wait();
            System.out.println("--------------------" + new Date());
        };
    }

    static class WaitDemo implements Runnable{

        @Override
        public void run() {
            try {

                synchronized (object){
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("111111111111");

                    object.notifyAll();

                    System.out.println("唤醒线程！！！");

                    List list = new ArrayList<String>();

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
