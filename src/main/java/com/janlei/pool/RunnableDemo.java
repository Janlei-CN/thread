package com.janlei.pool;

import java.util.concurrent.CountDownLatch;

public class RunnableDemo implements Runnable {
    public RunnableDemo(){}
    private CountDownLatch cdl=new CountDownLatch(10);
    private Thread t;
    private String threadName;
    private Singleton slt;
    {
        slt= Singleton.getInstance();
    }
   public RunnableDemo(String name) {
      threadName = name;
      System.out.println("Creating " +  threadName );
   }
   
   public void run() {
      System.out.println("Running " +  threadName );
       try {
         for(int i = 4; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i+"no");
            // 让线程睡眠一会
            Thread.sleep(500);
         }
      }catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
      System.out.println("Thread " +  threadName + " exiting.");
   }
   
   public void start () {
      System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
}