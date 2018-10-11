package study.jdk.concurrent.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lock1Main {

    private static int sum = 0;

    private static final int TIME = 5000;

    private Lock lock = new ReentrantLock();

    private static CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] args) {
        Lock1Main main = new Lock1Main();
        Thread t1 = new Thread(() -> {
            main.count();
//            main.safeCount();
            latch.countDown();
        });
        Thread t2 = new Thread(() -> {
            main.count();
//            main.safeCount();
            latch.countDown();
        });
        t1.start();
        t2.start();

        try {
            latch.await();
        } catch (InterruptedException ex) {
        }
        System.out.println("sum= " + sum);
    }

    private void count() {
        for (int i = 0; i < TIME; i++) {
            sum++;
        }
    }

    private void safeCount() {
        lock.lock();
        try {
            for (int i = 0; i < TIME; i++) {
                sum++;
            }
        } catch (Exception ex) {

        } finally {
            lock.unlock();
        }
    }
}
