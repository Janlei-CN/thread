package com.janlei.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorsTest {

    private ExecutorService ex;

    /**
     * 线程池
     */
    private ThreadPoolExecutor te;
    /**
     * inti size==16 0r 无界
     * @param name
     * @return ExecutorService
     */
    public ExecutorService init(String name){
        switch (name) {

            /**
             * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
             */
            case "cached":
                ex = Executors.newCachedThreadPool();
                break;

            /**
             * 创建一个指定工作线程数量的线程池。每当提交一个任务就创建一个工作线程，如果工作线程数量达到线程池初始的最大数，则将提交的任务存入到池队列中
             */
            case "fixed":
                ex = Executors.newFixedThreadPool(16);
                break;

            /**
             * 创建一个单线程化的Executor，即只创建唯一的工作者线程来执行任务，
             * 它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO,优先级)执行。
             * 如果这个线程异常结束，会有另一个取代它，保证顺序执行。
             * 单工作线程最大的特点是可保证顺序地执行各个任务，并且在任意给定的时间不会有多个线程是活动的。
             */
            case "single":
                ex = Executors.newSingleThreadExecutor();
                break;

            /**
             * newScheduleThreadPool
             * 创建一个定长的线程池，而且支持定时的以及周期性的任务执行，支持定时及周期性任务执行。
             */
            default:
                ex = Executors.newScheduledThreadPool(16);
        }
        return ex;
    }

    public void use(){
        Thread thread = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.print(i+" ");
            }
        });
        ex.submit(thread);//本类的执行方法 返回Future<T>
        //ex.execute(thread);//父类的方法 执行方法没有返回结果
    }

    public static void main(String[] args) {
        ExecutorsTest test = new ExecutorsTest();
        test.init("single");
        test.use();

    }
}
