package com.janlei.util.test;


import com.janlei.thread.pool.RunnableDemo;

import java.util.concurrent.CountDownLatch;

public class TestThread {

    public static void main(String args[]) {
        CountDownLatch cdl=new CountDownLatch(10);
        RunnableDemo R1 = new RunnableDemo("Thread-1");
        cdl.countDown();
        RunnableDemo R2 = new RunnableDemo("Thread-2");
        R1.start();
        R2.start();
    }
}