package study.jdk.concurrent.lock;

import study.Sleeps;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
//            if (lock.tryLock()) {
            if (lock.tryLock(4, TimeUnit.SECONDS)) {
                try {
                    System.out.println("i am t2 thread");
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("未获取到锁");
            }
        });
        t1.start();
        t2.start();
    }
}
