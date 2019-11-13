package com.janlei.util.jol;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.locks.ReentrantLock;

public class SeeCodeHeader {

    ReentrantLock lock = new ReentrantLock();

    @Test
    public void test(){
        System.out.println(ClassLayout.parseInstance(this).toPrintable());
        lock.lock();
        System.out.println(ClassLayout.parseInstance(this).toPrintable());
        lock.unlock();
        System.out.println(ClassLayout.parseInstance(this).toPrintable());
    }
}
