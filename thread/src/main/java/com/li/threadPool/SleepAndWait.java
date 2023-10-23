package com.li.threadPool;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author kuan
 * @version 1.0
 * @description: SleepAndWait
 * @date 2023/10/13 0:34
 */
@Slf4j

public class SleepAndWait {
    private static Object monitor = new Object();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    private static ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();


    public static void main(String[] args) throws InterruptedException {


        new Thread(() -> {
            System.out.println("子线程启动");
            synchronized (monitor) {
                try {

                    Thread.sleep(5000);
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(1000);

        synchronized (monitor) {
            System.out.println("主线程执行");
        }


    }


}
