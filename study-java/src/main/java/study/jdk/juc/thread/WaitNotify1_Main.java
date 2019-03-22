package study.jdk.juc.thread;

import study.Loggers;

/**
 * 等待/通知
 */
public class WaitNotify1_Main {

    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                Loggers.info("A 1");
                try {
                    lock.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                Loggers.info("A 2");
                Loggers.info("A 3");
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                Loggers.info("B 1");
                Loggers.info("B 2");
                Loggers.info("B 3");

                lock.notify();
            }
        }, "t2");
        t1.start();
        t2.start();
    }
}
