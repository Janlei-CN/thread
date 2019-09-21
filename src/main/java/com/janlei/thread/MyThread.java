package com.janlei.thread;

public class MyThread extends Thread{

    private int i=0;

    @Override
    public void run() {
        test();
    }

    private int test(){
        return i++;
    }

}