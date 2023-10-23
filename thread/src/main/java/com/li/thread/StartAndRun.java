package com.li.thread;


import lombok.extern.slf4j.Slf4j;

/**
 * @author kuan
 * @version 1.0
 * @description: TODO
 * @date 2023/10/12 18:23
 */
@Slf4j
public class StartAndRun {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            log.info("2.子线程启动" + Thread.currentThread().getName());
        });
        log.info("1.创建线程");

        thread.setName("lk");
//        thread.start(); //异步

        thread.run(); //同步
        log.info("3.主线程");
    }

}
