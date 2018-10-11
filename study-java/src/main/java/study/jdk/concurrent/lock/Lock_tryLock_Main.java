package study.jdk.concurrent.lock;

import study.Sleeps;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lock_tryLock_Main {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("i am t1 thread");
                Sleeps.seconds(10);
            } finally {
                lock.unlock();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                System.out.println("i am t2 thread");
            } finally {
                lock.unlock();
            }
        });
        t1.start();
        t2.start();
    }
}
