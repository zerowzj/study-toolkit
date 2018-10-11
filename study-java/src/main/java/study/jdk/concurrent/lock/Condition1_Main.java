package study.jdk.concurrent.lock;

import study.Sleeps;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Condition1_Main {

    private static int sum = 0;

    private static Lock lock = new ReentrantLock();

    private static Condition condition = lock.newCondition();

    private static volatile boolean running = true;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                while (running) {
                    sum = sum + 100;
                    Sleeps.milliseconds(500);
                    System.out.println("==>" + sum);
                    if (sum == 2000) {
                        System.out.println("t1 signal start");
                        condition.signal();
                        System.out.println("t1 signal end");

                        running = false;
                    }
                }
            } finally {
                lock.unlock();
            }

        });

        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("t2 await start");
                condition.await();
                System.out.println("t2 await end");
                System.out.println("t2 sum= " + sum);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        t2.start();
        Sleeps.seconds(1);
        t1.start();
    }
}
