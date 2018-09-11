package study.jdk.concurrent.thread;

import study.jdk.concurrent.SleepUtils;

public class StateTest {

    static Object LOCK = new Object();

    public static void main(String[] args) {
        new Thread(new TimedWaiting(), "TimedWaitingThread").start();
        new Thread(new Waiting(), "WaitingThread").start();
        new Thread(new Blocked(), "BlockedThread-1").start();
        new Thread(new Blocked(), "BlockedThread-2").start();
    }

    static class TimedWaiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(100);
            }
        }
    }

    static class Waiting implements Runnable {
        @Override
        public void run() {
            synchronized (Waiting.class) {
                try {
                    Waiting.class.wait();

                    //lock.wait();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    static class Blocked implements Runnable {
        @Override
        public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    SleepUtils.second(100);
                }
            }
        }
    }
}
