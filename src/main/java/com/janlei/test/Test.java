package com.janlei.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * test thread
 */
public class Test {
    static volatile int i=0;
     public static void main(String[] args) {   
         final CountDownLatch latch = new CountDownLatch(4);
         long count = latch.getCount();
         int N=10000;
         CyclicBarrier barrier  = new CyclicBarrier(N);
         for(int i=0;i<N;i++) {
             new Thread(() -> demo(latch)).start();
         }
         try {
             System.out.println(String.format("等待%s个子线程执行完毕...",count));
            latch.await();
             System.out.println(String.format("%s个子线程已经执行完毕",count));
             System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     }
     public static void demo(CountDownLatch latch){
        /* try {
             System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
             Thread.sleep(3000);
             System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
             latch.countDown();
             System.out.println(latch.getCount());
         } catch (InterruptedException e) {
             e.printStackTrace();
         }*/
             System.out.println(getNumber());

     }
     public static int getNumber(){
         return i++;
     }
}