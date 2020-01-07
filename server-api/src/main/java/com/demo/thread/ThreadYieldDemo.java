package com.demo.thread;

public class ThreadYieldDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new YieldDemo("thread-1"));
        Thread t2 = new Thread(new YieldDemo("thread-2"));

        t1.setPriority(2);//设置线程优先级，越大越高
        t2.setPriority(3);//设置线程优先级，越大越高

        t1.start();
        t2.start();
    }

    static class YieldDemo implements Runnable{

        private String name;

        public YieldDemo(String name) {
            this.name = name;
        }

        @Override
        public void run() {

            Thread t = Thread.currentThread();

            for (int i = 0; i <15 ; i++) {
                System.out.println(String.format("%s [%d] ---> %d", this.name, t.getPriority(), i));
                if(i == 1 && name.equals("thread-1")){
                    System.out.println("让thread-2线程先执行！");
                    Thread.yield();
                    System.out.println("11让thread-2线程先执行！");
                    System.out.println("-------让thread-2线程先执行！");
                }

            }

        }
    }
}
