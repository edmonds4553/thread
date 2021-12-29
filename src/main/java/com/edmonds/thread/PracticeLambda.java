package com.edmonds.thread;

/**
 * @author ft
 * @version 1.0
 * @date 2021/12/29 10:26
 */
public class PracticeLambda {


    public static void main(String[] args) {
        new Thread(() -> System.out.println("===============")).start();

        new Thread(() -> {
            System.out.println("opensea");
            System.out.println("mvsea");
        }).start();

        Model model = a -> System.out.println(a);
        model.work(100);
    }
}

interface Model {
    void work(int a);
}

