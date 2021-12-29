package com.edmonds.thread;

/**
 * @author ft
 * @version 1.0
 * @date 2021/12/29 10:12
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("子线程");
        }
    }

    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        myThread.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("main线程");
        }
    }
}
