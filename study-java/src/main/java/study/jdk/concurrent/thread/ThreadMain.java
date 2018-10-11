package study.jdk.concurrent.thread;

import study.Sleeps;

public class ThreadMain {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Sleeps.minutes(10);
        });
        t.start();
        t.start();
    }
}
