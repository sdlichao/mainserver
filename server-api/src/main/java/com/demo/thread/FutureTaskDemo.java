package com.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Double> task = new FutureTask<Double>(new MyCallable());
        Thread thread = new Thread(task);

        thread.start();

        System.out.println("======="+task.get());
        Thread.sleep(5000);
        System.out.println("主线程等待计算结果...");


        Thread thread1 = new Thread(task);
        thread1.start();
//        System.out.println("++++++++++"+task.get());
    }

}

class MyCallable implements Callable<Double>{

    @Override
    public Double call() throws Exception {
        double d = 0;

        System.out.println("异步计算开始...");
        d = Math.random()*10;
        d+=1000;

        Thread.sleep(1000);

        System.out.println("异步计算结果...");
        return d;
    }
}


