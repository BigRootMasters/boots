package com.li.thread;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author kuan
 * @version 1.0
 * @description: TODO
 * @date 2023/10/12 18:38
 */
@Slf4j
public class Sleep {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("2.子线程启动");
        });
        log.info("1.创建线程");
//        thread.run(); //同步
        thread.setName("lk");
        thread.start(); //异步
        log.info("3.主线程");
    }
}
