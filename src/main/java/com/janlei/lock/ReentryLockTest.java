package com.janlei.lock;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

public class ReentryLockTest {

    private  static Integer i=0;
    private ReentrantLock lock;
    {

        lock = new ReentrantLock();
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[100000];
        for (int j = 0; j < threads.length; j++) {
                threads[j] = new Thread(() -> {

                    //保证i++的原子性
                    synchronized (ReentryLockTest.class) {
                        i++;
                    }

                });
        }
        for (Thread thread: threads) thread.start();
        for (Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(i);

        
    }

    /**
     * 没有保证多线程锁执行的有序性
     */
    @Test
    public void test(){

        lock.lock();
        new Thread(() -> {
            System.out.println("zansan1");
        }).start();

        lock.unlock();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        new Thread(() -> System.out.println("zansan2")).start();
        lock.unlock();

    }
}
