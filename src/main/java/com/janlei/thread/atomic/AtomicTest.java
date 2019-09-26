package com.janlei.thread.atomic;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    int count = 0;

    AtomicInteger count2 = new AtomicInteger(0);

    synchronized void m() {
        count++;
    }

    void m2() {
        count2.incrementAndGet();
    }

    public static void getTime(AtomicTest t,Boolean flag)throws InterruptedException{
        long start = new Date().getTime();
        for (int i = 0; i < 1000; i++) {
            Thread thread=flag?new Thread(t::m):new Thread(t::m2);
            thread.start();
            thread.join();
        }
        long end = new Date().getTime();
        System.out.println("耗用时间 " + (end - start));
    }

    /**
     * compare Atomic to synchronized
     * @throws InterruptedException
     */
    private static void compare()throws InterruptedException {
        AtomicTest t = new AtomicTest();
        getTime(t,true);
        getTime(t,false);
    }

    public static void main(String[] args) throws InterruptedException {
        compare();
    }
}
