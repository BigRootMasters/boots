package com.li.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author kuan
 * @version 1.0
 * @description: ExecuteSubmit
 * @date 2023/10/12 20:48
 */
@Slf4j
public class ExecuteSubmit {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

//        Future<?> future = threadPool.submit(() -> {
//            System.out.println("执行子线程");
//            return 5;
//        });
//        System.out.println(future.get());

        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            log.info("execute task");
            return 3;
        });
        threadPool.execute(futureTask);
        Integer integer = futureTask.get();
        System.out.println(integer);


    }
}
