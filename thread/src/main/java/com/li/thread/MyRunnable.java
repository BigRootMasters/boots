package com.li.thread;

/**
 * @author kuan
 * @version 1.0
 * @description: MyRunnable
 * @date 2023/10/12 18:08
 */

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("线程Runnable");
    }
}
