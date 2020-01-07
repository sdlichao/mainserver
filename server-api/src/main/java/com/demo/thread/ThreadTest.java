package com.demo.thread;

import io.micrometer.core.instrument.util.NamedThreadFactory;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest {

    public static void main(String[] args) throws IOException {

        int corePoolSize = 2;
        int maxMumPoolSize = 4;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(2);
        ThreadFactory threadFactory = new NamedThreadFactory();
        RejectedExecutionHandler handler = new MyIgnorePolicy();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize,maxMumPoolSize,keepAliveTime,unit,workQueue,threadFactory, handler);
        executor.prestartAllCoreThreads();

        for (int i = 1; i <11 ; i++) {
            System.out.println(i+"********************************************"+new Date());
            MyTask myTask = new MyTask(String.valueOf(i));
            executor.execute(myTask);
        }

        System.in.read();
    }


    static class MyIgnorePolicy implements RejectedExecutionHandler {
        public void rejectedExecution(Runnable r , ThreadPoolExecutor e){
            doLog(r , e);
        }

        private void doLog(Runnable r, ThreadPoolExecutor e) {
            System.err.println(r.toString() + " rejected");
        }

    }

    static class NamedThreadFactory implements ThreadFactory{

        private final AtomicInteger mThread = new AtomicInteger(1);

        public Thread newThread(Runnable r) {
            Thread t = new Thread(r , "my-thread-"+mThread.getAndIncrement());
            System.out.println(t.getName() + " has been created");
            return t;
        }
    }

    static class MyTask implements Runnable{
        private String name ;

        public MyTask(String name) {
            this.name = name;
        }

        public void run() {
            try {


                System.out.println(this.toString() + " is running!!!");
                Thread.sleep(3000);

                String threadName = Thread.currentThread().getName();
                System.out.println(new Date()+"------------------Thread is name "  + threadName);

//                System.out.println(this.toString() + " is end!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "MyTask [name=" + name + "]";
        }
    }
}
