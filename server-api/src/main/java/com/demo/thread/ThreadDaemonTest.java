package com.demo.thread;

import java.io.IOException;

public class ThreadDaemonTest {

    public static void main(String[] args) throws IOException {
        ThreadDemo td = new ThreadDemo();
        td.setDaemon(true);//设置守护线程,主线程结束，td线程结束

        td.start();

        System.out.println("isDaemon = " + td.isDaemon());

        System.in.read();
    }

    static class ThreadDemo extends Thread{

        @Override
        public void run() {
            for (int i = 0;  ; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }
    }
}
