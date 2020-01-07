package com.demo.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest1 {
    public static void main(String[] args) {
        int corePoolSize=2;
        int maximumPoolSize=4;
        long keepAliveTime=10;
        TimeUnit unit = TimeUnit.SECONDS;
//        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(3);

        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<Runnable>();
        ThreadFactory threadFactory = new ThreadFactoryDemo();
        RejectedExecutionHandler handler = new NameRejectedHandler();
        ThreadPoolExecutor tpe = new ThreadPoolExecutor( corePoolSize,maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
        tpe.prestartAllCoreThreads();


        for (int i = 1; i < 11; i++) {
            MyTask myTask = new MyTask(String.valueOf(i));
            tpe.execute(myTask);
        }

    }

    private static class ThreadFactoryDemo implements ThreadFactory {

        private AtomicInteger ai = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            ai.incrementAndGet();
            Thread t = new Thread(r,"thread_name_"+ai);
            return t;
        }
    }

    private static class NameRejectedHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println(r.toString() + " rejected !!!");
        }


    }

    static class MyTask implements Runnable {

        private String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("MyTask is running ----- " + name);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "MyTask is name "+name;
        }
    }
}
