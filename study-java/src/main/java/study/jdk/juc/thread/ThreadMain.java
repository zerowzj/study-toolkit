package study.jdk.juc.thread;

import study.Sleeps;

public class ThreadMain {

    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test1() {
        Thread t = new Thread(() -> {
            Sleeps.minutes(10);
        });
        t.start();
        t.start();
    }

    private static void test2() {
        Thread t = new Thread(() -> {
        });
        t.start();
        t.start();
    }
}
