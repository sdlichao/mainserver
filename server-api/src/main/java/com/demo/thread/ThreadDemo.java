package com.demo.thread;

public class ThreadDemo extends Thread {

    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();

        td.start();

        Thread tdemo = new Thread(){
            public void run(){
                System.out.println("---------------------------");
            }
        };

        tdemo.start();

        Thread runnable = new Thread(new ThreadRunnable());
        runnable.start();
    }

    public void run(){
        System.out.println("thread is start!!!");
    }

    static class ThreadRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(" Runnable is start!!! ");
        }
    }
}
