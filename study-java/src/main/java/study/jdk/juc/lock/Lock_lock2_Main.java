package study.jdk.juc.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示：阻塞获取锁且不可中断
 */
public class Lock_lock2_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Lock_lock2_Main.class);

    private Lock lock = new ReentrantLock();

    public void test() {
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                LOGGER.info("i am thread t1");
                Sleeps.deep();
            } finally {
                lock.unlock();
            }
        });
        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                LOGGER.info("i am thread t2 ");
            } finally {
                lock.unlock();
            }
        });

        t1.start();
        Sleeps.seconds(1);
        t2.start();

        Sleeps.seconds(3);
        t2.interrupt();
    }

    public static void main(String[] args) {
        new Lock_lock2_Main().test();
    }
}
