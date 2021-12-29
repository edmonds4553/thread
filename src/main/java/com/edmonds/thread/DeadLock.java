package com.edmonds.thread;

import java.util.concurrent.ExecutionException;

/**
 * @author ft
 * @version 1.0
 * @date 2021/12/29 10:26
 */
public class DeadLock {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

    }
}

class Fish {

}

class Bear {

}


class Exchange implements Runnable {
    Fish fish = new Fish();
    Bear bear = new Bear();

    private int type;

    private String name;

    public Exchange(int type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public void run() {
        if (type == 0) {
            synchronized (fish) {
                System.out.println(Thread.currentThread().getName() + "拿到fish锁");
                synchronized (bear) {
                    System.out.println(Thread.currentThread().getName() + "拿到bear锁");
                }
            }
        } else {
            synchronized (bear) {
                System.out.println(Thread.currentThread().getName() + "拿到bear锁");
                synchronized (fish) {
                    System.out.println(Thread.currentThread().getName() + "拿到fish锁");
                }
            }
        }
    }
}












