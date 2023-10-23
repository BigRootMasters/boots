package com.li.thread;


/**
 * @author kuan
 * @version 1.0
 * @description: CreateThread
 * @date 2023/10/12 18:12
 */

public class CreateThread {

    public static void createRunnable() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程Runnable");
            }
        });
        thread.start();
    }

    public static void createRunnableLambda() {
        Thread thread = new Thread(() -> {
            System.out.println("Runnable lambda");
        });
        thread.start();
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        //推荐使用runnable,因为单继承多实现
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        System.out.println(thread.getState());
        System.out.println("主线程");
    }
}
