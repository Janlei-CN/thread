package com.janlei.thread.sync;

/**
 * 多线程操作的原子性
 */
public class SynchronizedTest implements Runnable {

    /**
     * 使用volatile可以使各个线程的数据同步
     */
    private int count = 10;

    /**
     * 没有Synchronized
     * Thread-1-count = 8
     * Thread-2-count = 7
     * Thread-0-count = 9
     * Thread-3-count = 6
     * Thread-4-count = 5
     * 循环次数：1
     * <p>
     * synchronized (SynchronizedTest.class) {
     * count--;
     * }
     * Thread-30-count = 9
     * Thread-31-count = 8
     * Thread-32-count = 7
     * Thread-33-count = 6
     * Thread-34-count = 5
     * 循环次数：7
     * <p>
     * 还是无法保证原子性
     */
    @Override
    public synchronized void run() {
//        synchronized (SynchronizedTest.class) {
//            count--;
//        }
        count--;
        System.out.println(Thread.currentThread().getName() + "-count = " + count);
    }

    public static void main(String[] args) {
        int index = 0;
        for (int i = 0; i < 10; i++) {
            SynchronizedTest t = new SynchronizedTest();
            for (int j = 0; j < 5; j++) {
                new Thread(t).start();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            index++;
            System.out.println("循环次数：" + index);
        }
    }
}
