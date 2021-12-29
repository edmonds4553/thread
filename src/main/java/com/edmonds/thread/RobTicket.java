package com.edmonds.thread;

/**
 * 抢票
 *
 * @author ft
 * @version 1.0
 * @date 2021/12/29 10:26
 */
public class RobTicket implements Runnable {

    private int ticket = 10;

    @Override
    public void run() {
        while (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到第" + ticket-- + "张票");
        }
    }

    public static void main(String[] args) {
        RobTicket myThread = new RobTicket();
        new Thread(myThread, "aruis").start();
        new Thread(myThread, "edmonds").start();
    }
}

