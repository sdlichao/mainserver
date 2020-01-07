package com.demo.thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ThreadJoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new JoinTest("one",10));
        Thread t2 = new Thread(new JoinTest("two",4));

        t1.start();
        t2.start();

        t2.wait();

        t1.join(1000);
        t2.join(1000);

        System.out.println(t1.isAlive());

        System.out.println("main end!!!");
    }

    static class JoinTest implements Runnable {

        private String name;
        private int sleepTime;

        public JoinTest(String name , int sleepTime) {
            this.name = name;
            this.sleepTime = sleepTime;
        }

        @Override
        public void run() {
            System.out.printf("%S begins: %S \n" , name , new Date());

            try {
                TimeUnit.SECONDS.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%S begins: %S \n" , name , new Date());
        }
    }
}
