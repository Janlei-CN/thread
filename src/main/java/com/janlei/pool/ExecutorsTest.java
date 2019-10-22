package com.janlei.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest {

    private ExecutorService ex;

    /**
     * inti size==16 0r 无界
     * @param name
     * @return
     */
    public ExecutorService init(String name){
        switch (name) {
            case "cached":
                ex = Executors.newCachedThreadPool();
                break;
            case "fixed":
                ex = Executors.newFixedThreadPool(16);
                break;
            case "single":
                ex = Executors.newSingleThreadExecutor();
                break;
            default:
                ex = Executors.newScheduledThreadPool(16);
        }
        return ex;
    }
}
