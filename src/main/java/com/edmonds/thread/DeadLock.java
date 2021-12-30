package com.edmonds.thread;

import java.util.concurrent.ExecutionException;

/**
 * @author ft
 * @version 1.0
 * @date 2021/12/29 10:26
 */
public class DeadLock {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread(new Exchange(0), "edmonds").start();
        new Thread(new Exchange(1), "aruis").start();
    }
}

class Fish {

}

class Bear {

}


class Exchange implements Runnable {
    static Fish fish = new Fish();
    static Bear bear = new Bear();

    private int type;

    public Exchange(int type) {
        this.type = type;
    }

    @Override
    public void run() {
        //死锁
//        if (type == 0) {
//            synchronized (fish) {
//                System.out.println(Thread.currentThread().getName() + "拿到fish锁");
//                synchronized (bear) {
//                    System.out.println(Thread.currentThread().getName() + "拿到bear锁");
//                }
//            }
//        } else {
//            synchronized (bear) {
//                System.out.println(Thread.currentThread().getName() + "拿到bear锁");
//                synchronized (fish) {
//                    System.out.println(Thread.currentThread().getName() + "拿到fish锁");
//                }
//            }
//        }

        if (type == 0) {
            synchronized (fish) {
                System.out.println(Thread.currentThread().getName() + "拿到fish锁");
            }
            synchronized (bear) {
                System.out.println(Thread.currentThread().getName() + "拿到bear锁");
            }
        } else {
            synchronized (bear) {
                System.out.println(Thread.currentThread().getName() + "拿到bear锁");
            }
            synchronized (fish) {
                System.out.println(Thread.currentThread().getName() + "拿到fish锁");
            }
        }
    }
}












