package study.jdk.concurrent.lock;

import study.Sleeps;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 非阻塞获取锁
 */
public class Lock_tryLock_Main {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("i am t1 thread");
                Sleeps.seconds(3);
            } finally {
                lock.unlock();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                //TODO 立即返回
//                if (lock.tryLock()) {
                //TODO 超时返回
                if (lock.tryLock(2, TimeUnit.SECONDS)) {
                    try {
                        System.out.println("i am t2 thread");
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println("未获取到锁");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });
        t1.start();
        t2.start();
    }
}
