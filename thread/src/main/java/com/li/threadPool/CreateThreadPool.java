package com.li.threadPool;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kuan
 * @version 1.0
 * @description: CreateThreadPool
 * @date 2023/10/12 20:27
 */
@Slf4j
public class CreateThreadPool {

    public static void main(String[] args) {
        class Task implements Runnable {
            @Override
            public void run() {
                log.info("\t 办理业务");
            }
        }
        Task task = new Task();
        //固定线程
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //单个线程
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //动态扩容
//        ExecutorService threadPool = Executors.newCachedThreadPool();
        //定时调度
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        try {
            for (int i = 0; i <= 10; i++) {
                threadPool.execute(task);
//                scheduledExecutorService.schedule(task,5, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //线程池关闭,所有任务执行后关闭
            threadPool.shutdown();
            //线程池关闭,正在执行的任务执行后关闭
            threadPool.shutdownNow();
//            scheduledExecutorService.shutdown();
            System.out.println(threadPool.isTerminated());
//            System.out.println(scheduledExecutorService.isTerminated());
        }
    }


}
