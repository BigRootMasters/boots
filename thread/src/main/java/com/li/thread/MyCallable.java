package com.li.thread;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author kuan
 * @version 1.0
 * @description: TODO
 * @date 2023/10/12 18:41
 */
@Slf4j
public class MyCallable {

    public static FutureTask<String> createCallable(String s) {
        FutureTask<String> task = new FutureTask<String>(() -> {
            log.info(s);
            return s;
        });
        return task;
    }

    public static void main(String[] args) {
        FutureTask<String> futureTask = createCallable("2");
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            String s = futureTask.get();
            log.info(s);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
