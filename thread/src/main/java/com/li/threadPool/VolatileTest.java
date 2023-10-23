package com.li.threadPool;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kuan
 * @version 1.0
 * @description: TODO
 * @date 2023/10/12 22:22
 */

public class VolatileTest {
    static Boolean always = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (always) {
                System.out.println("system 中有 synchronized");
//                synchronized (always){
//
//                }
            }
        }).start();
        Thread.sleep(2000);
        always = false;

        ReentrantLock lock = new ReentrantLock();
    }
}

