package study.jvm.jstatck;

import study.Sleeps;

/**
 * （1）死锁时线程堆栈信息
 */
public class DeadLock_Main {

    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                Sleeps.seconds(5);
                synchronized (lock2) {

                }
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                synchronized (lock1) {

                }
            }
        }, "t2");
        t1.start();
        t2.start();
    }
}
