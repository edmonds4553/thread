package com.edmonds.thread;

/**
 * @author ft
 * @version 1.0
 * @date 2021/12/29 10:26
 */
public class Signal {

    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
        new Producer(synContainer).start();
        new Consumer(synContainer).start();
    }
}

class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}


//生产者
class Producer extends Thread {

    SynContainer synContainer;

    public Producer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产了" + i + "只鸡");
            synContainer.push(new Chicken(i));
        }
    }
}

//消费者
class Consumer extends Thread {

    SynContainer synContainer;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了" + i + "只鸡");
            synContainer.pop();
        }
    }
}

//缓存池，管程法
class SynContainer {
    Chicken[] chickens = new Chicken[10];
    int count = 10;

    //生产
    public synchronized void push(Chicken chicken) {
        if (count == chickens.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        chickens[count] = chicken;
        count++;
        this.notifyAll();
    }

    //消费
    public synchronized void pop() {
        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        this.notifyAll();
    }
}