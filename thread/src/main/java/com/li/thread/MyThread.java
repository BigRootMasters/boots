package com.li.thread;

/**
 * @author kuan
 * @version 1.0
 * @description: MyThread
 * @date 2023/10/12 18:06
 */

public class MyThread extends Thread {
//重写run方法

    @Override
    public void run() {
        System.out.println("线程Thread");
    }
}
