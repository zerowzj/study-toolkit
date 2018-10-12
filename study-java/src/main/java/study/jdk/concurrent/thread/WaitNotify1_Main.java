package study.jdk.concurrent.thread;

import study.Loggers;

/**
 * 等待/通知
 */
public class WaitNotify1_Main {

    public static void main(String[] args) {
        Object lock = new Object();

        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    Loggers.info("A 1");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Loggers.info("A 2");
                    Loggers.info("A 3");
                }
            }
        }, "BThread");

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    Loggers.info("B 1");
                    Loggers.info("B 2");
                    Loggers.info("B 3");

                    lock.notify();
                }
            }
        }, "Athread");
        A.start();
        B.start();
    }
}
