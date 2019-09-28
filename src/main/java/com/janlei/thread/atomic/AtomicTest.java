package com.janlei.thread.atomic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    int m3(){
        count2.addAndGet(1);
        count2.addAndGet(2);
        count2.addAndGet(3);
        count2.addAndGet(4);
        return count2.get();
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
     * test Atomicity
     */
    @Test
    public void atomic(){
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(() -> System.out.println(m3())));
        }
        threads.forEach(Thread::start);
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
