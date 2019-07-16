package study.jvm.jstatck;

import study.Sleeps;

/**
 * （1）BLOCKED时线程堆栈信息
 */
public class Blocked1_Main {

    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                Sleeps.deep();
            }
        }, "jmap");
        t1.start();

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
            }
        }, "t2");
        t2.start();
    }
}
