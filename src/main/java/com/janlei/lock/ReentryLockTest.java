package com.janlei.lock;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

public class ReentryLockTest {

    private ReentrantLock lock;
    {

        lock = new ReentrantLock();
    }

    public static void main(String[] args) {
        ReentryLockTest test = new ReentryLockTest();

        test.test();
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
