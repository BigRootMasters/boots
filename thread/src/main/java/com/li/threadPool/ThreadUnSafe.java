package com.li.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kuan
 * @version 1.0
 * @description: TODO
 * @date 2023/10/12 22:18
 */

public class ThreadUnSafe {
    /**
     * 原子性 ：lock，synchronized
     * 一致性:
     * 可见性 : volatile
     **/

    public static Integer stock = 10000;

    private static final ReentrantLock lock = new ReentrantLock();

//    public static volatile AtomicInteger stock = new AtomicInteger(10000);


    static class stockRunnable implements Runnable {

//        @Override
//        public void run() {
//            if (stock > 0) {
//                stock--;
//            }
//        }


//        @Override
//        public synchronized void run() {
//            if (stock > 0) {
//                stock--;
//            }
//        }

        @Override
        public void run() {
            try {
                lock.lock();
                if (stock > 0) {
                    stock--;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
        }


//        @Override
//        public void run() {
//            if (stock.get() > 0) {
//                stock.decrementAndGet();
//            }
//        }
    }

    /**
     * 1.synchronized
     * 2.lock
     **/
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        stockRunnable stockRunnable = new stockRunnable();
        try {
            for (int i = 0; i < 1000000; i++) {
                threadPool.execute(stockRunnable);
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
