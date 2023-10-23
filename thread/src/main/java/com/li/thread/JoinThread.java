package com.li.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author kuan
 * @version 1.0
 * @description: TODO
 * @date 2023/10/12 18:48
 */

public class JoinThread {
    static int value = 1;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            //业务
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            value = 10;
            System.out.println("线程Runnable" + value);
        });
        t1.start();
        System.out.println(t1.isAlive());//线程是否存活
        t1.join(); //join主线程等待子线程执行后在执行完毕
        System.out.println(t1.isAlive());
        t1.interrupt();
        System.out.println("主线程" + value);
    }
}
