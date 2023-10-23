package com.li.threadPool;

import java.util.concurrent.*;

/**
 * @author kuan
 * @version 1.0
 * @description: TODO
 * @date 2023/10/12 17:10
 */

public class MyThreadPool {
    /**
     * corePoolSize: 核心线程数量
     * maxNumPoolSize: 最大线程数量
     * keepAliveTime: 最大存活时间
     * keepAliveTimeUnit: 最大时间存活单位
     * BlockingQueue:阻塞队列类型
     * ThreadFactory: 线程工厂
     * RejectedPoolExecutorHandler: 拒绝策略
     **/

    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(10,
                20,
                0L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        class Task implements Runnable {
            int i = 0;

            public Task(int i) {
                this.i = i;
            }

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "我的第 " + i + "个 项目");
                try {
                    Thread.sleep(5000L);//业务
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            for (int i = 0; i < 100; i++) {
                Task task = new Task(i);
                threadPool.execute(task);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }
}
