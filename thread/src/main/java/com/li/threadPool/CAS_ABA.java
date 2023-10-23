package com.li.threadPool;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author kuan
 * @version 1.0
 * @description: TODO
 * @date 2023/10/13 0:15
 */

public class CAS_ABA {

    public static void old() {

        //余额
        AtomicInteger balance = new AtomicInteger(1000);

        System.out.println("A张三:" + balance.get());


        //财务发钱
        int newValue = balance.addAndGet(3000);
        balance.compareAndSet(balance.get(), newValue);
        System.out.println("发钱:" + balance.get());


        //老婆取钱
        int inValue = balance.addAndGet(-3000);
        balance.compareAndSet(balance.get(), inValue);
        System.out.println("取钱:" + balance.get());


        //查看钱

        if (balance.get() > 3000) {
            int outValue = balance.addAndGet(-3000);
            System.out.println("张三消费后：" + balance.get());
        } else {
            System.out.println("张三找财务麻烦：" + balance.get());
        }

    }

    public static void newFun() {

        //余额
        AtomicStampedReference<Integer> balance = new AtomicStampedReference<Integer>(1000, 0);
        System.out.println("A张三:" + balance.getReference());

        //财务发钱
        balance.compareAndSet(balance.getReference(), 4000, balance.getStamp(), balance.getStamp() + 1);
        System.out.println("发钱:" + balance.getReference());

        //老婆取钱
        balance.compareAndSet(balance.getReference(), 1000, balance.getStamp(), balance.getStamp() + 1);
        System.out.println("取钱:" + balance.getReference());

        //查看钱
        if (balance.getReference() > 3000) {
            System.out.println("张三消费后：" + balance.getReference());
        } else {
            if (balance.getStamp() == 1) {
                System.out.println("财务不对");
            } else {
                System.out.println("张三找老婆麻烦：" + balance.getReference());
            }
            System.out.println(balance.getStamp());
        }
    }

    public static void main(String[] args) {
        newFun();
    }
}
