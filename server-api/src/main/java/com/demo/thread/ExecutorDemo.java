package com.demo.thread;

import com.alibaba.fastjson.JSON;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class ExecutorDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorDemo executorDemo = new ExecutorDemo();
//        executorDemo.submit();
        executorDemo.invokeAnyDemo();
    }

    public void submit() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("执行方法111");
                Thread.sleep(5000);
                System.out.println("方法111执行结束！！！！！！");
                return "111";
            }
        });


        executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("执行方法222");
                return "222";
            }
        });

        executorService.shutdown();

        System.out.println("开始等待");
        boolean b = executorService.awaitTermination(100 , TimeUnit.SECONDS);

        if(b){
            System.out.println("------------------------------+++++++++++++++++++++++");
        }
        System.out.println("等待结束");

    }

    public void execute(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new MyDemo("任务1"));
        executorService.execute(new MyDemo("任务2"));
        executorService.execute(new MyDemo("任务3"));
        executorService.shutdown();

        System.out.println("执行结束！！！");
    }

    public void invokeAnyDemo() throws ExecutionException, InterruptedException {

//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5,10,TimeUnit.SECONDS,
//        new SynchronousQueue<Runnable>());

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Set<Callable<String>> callables = new HashSet<Callable<String>>();

        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {

//                System.out.println("Thread.currentThread()111=" + JSON.toJSONString(Thread.currentThread()));
                Thread.sleep(1000);
                System.out.println("Task 1 is Running!!!");
                return "Task 1";
            }
        });

        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {

//                System.out.println("Thread.currentThread()222=" + JSON.toJSONString(Thread.currentThread()));
                Thread.sleep(1000);
//                Thread.currentThread().stop();
                System.out.println("Task 2 is Running!!!");
                return "Task 2";
            }
        });

        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {

//                System.out.println("Thread.currentThread()333=" + JSON.toJSONString(Thread.currentThread()));
                Thread.sleep(1000);
                System.out.println("Task 3 is Running!!!");
                return "Task 3";
            }
        });

        List<Future<String>> results = executorService.invokeAll(callables);
//        String result = executorService.invokeAny(callables);
        System.out.println("result111=" + results.get(1).get());

        executorService.shutdown();

    }

    public void getThreadInfo(){

    }
}

class MyDemo implements Runnable{

    private String name;

    public MyDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "启动执行MyTask!!!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
