package study.jdk.juc.thread;

import study.jdk.concurrent.SleepUtils;

public class InterruptedTest {

    public static void main(String[] args) {

    }

    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.seconds(10);
            }
        }
    }

    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
            }
        }
    }
}