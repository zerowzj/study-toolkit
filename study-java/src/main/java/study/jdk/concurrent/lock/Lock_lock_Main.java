package study.jdk.concurrent.lock;

import study.Sleeps;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阻塞获取锁
 */
public class Lock_lock_Main {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("i am t1 thread");
                Sleeps.seconds(5);
            } finally {
                lock.unlock();
            }
        });
        Thread t2 = new Thread(() -> {
            lock.lock();
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
