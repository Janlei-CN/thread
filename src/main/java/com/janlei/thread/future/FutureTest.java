package com.janlei.thread.future;

import org.junit.Test;

import java.util.concurrent.*;

public class FutureTest implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += i;
        }
        return sum;
    }

    @Test
    public void test(){
        ExecutorService executor = Executors.newCachedThreadPool();
        //FutureTest task = new FutureTest();
        Future<Integer> result = executor.submit(this);
        executor.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果"+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }
}