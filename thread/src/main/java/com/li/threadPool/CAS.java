package com.li.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kuan
 * @version 1.0
 * @description: TODO
 * @date 2023/10/12 23:57
 */

public class CAS {
    static AtomicInteger stock = new AtomicInteger(1000000);
//    static Integer stock = 1000000;

    static class Task implements Runnable {

//            @Override
//            public void run() {
//                if (stock > 0) {
//                    stock--;
//                }
//            }

//            @Override
//            public void run() {
//                if (stock.get() > 0) {
//                    stock.decrementAndGet();
//                }
//            }


        @Override
        public void run() {
            int oldValue;
            int newValue;
            do {
                oldValue = stock.get();
                newValue = oldValue - 1;
            } while (!stock.compareAndSet(oldValue, newValue));

        }
    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService threadPool = Executors.newCachedThreadPool();
        Task task = new Task();
        try {
            for (int i = 0; i < 1000000; i++) {
                threadPool.execute(task);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
            threadPool.awaitTermination(1000, TimeUnit.SECONDS);
        }
        System.out.println("剩余库存：" + stock);
    }
}
