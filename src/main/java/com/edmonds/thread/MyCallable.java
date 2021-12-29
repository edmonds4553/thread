package com.edmonds.thread;

import java.util.concurrent.*;

/**
 * @author ft
 * @version 1.0
 * @date 2021/12/29 10:26
 */
public class MyCallable implements Callable<Boolean> {


    @Override
    public Boolean call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程池
        ExecutorService service = Executors.newFixedThreadPool(3);
        MyCallable myCallable = new MyCallable();
        Future<Boolean> s1 = service.submit(myCallable);
        Future<Boolean> s2 = service.submit(myCallable);
        Future<Boolean> s3 = service.submit(myCallable);
        System.out.println(s1.get());
        System.out.println(s2.get());
        System.out.println(s3.get());
        //关闭服务
        service.shutdown();
    }
}

