package com.edmonds.thread;

/**
 * @author ft
 * @version 1.0
 * @date 2021/12/29 10:26
 */
public class MyRunnable implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("子线程");
        }
    }

    public static void main(String[] args) {
        MyRunnable myThread = new MyRunnable();
        new Thread(myThread).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("main线程");
        }
    }
}

