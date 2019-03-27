package study.jdk.juc.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阻塞获取锁
 */
public class Lock_lock1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Lock_lock1_Main.class);

    private Lock lock = new ReentrantLock();

    public void test() {
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                LOGGER.info("i am thread t1");
                Sleeps.seconds(5);
            } finally {
                lock.unlock();
            }
        });
        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                LOGGER.info("i am thread t2");
            } finally {
                lock.unlock();
            }
        });
        t1.start();
Sleeps.seconds(1);
        t2.start();
    }

    public static void main(String[] args) {
        new Lock_lock1_Main().test();
    }
}