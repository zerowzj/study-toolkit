package study.jdk.juc.aqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 演示：
 * （1）自定义简单自旋锁
 */
public class CAS1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(CAS1_Main.class);

    /*
     * 自旋锁
     */
    private class SpinLock {

        private AtomicReference<Thread> owner = new AtomicReference<>();

        public void lock() {
            Thread current = Thread.currentThread();
            while (!owner.compareAndSet(null, current)) {
                LOGGER.info("thread[{}] is spinning", current.getName());
                Sleeps.seconds(1);
            }
            LOGGER.info("thread[{}] get lock", current.getName());
        }

        public void unlock() {
            Thread current = Thread.currentThread();
            owner.compareAndSet(current, null);
        }
    }

    private void test() {
        SpinLock lock = new SpinLock();
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                LOGGER.info("i am t1 thread");
                Sleeps.seconds(10);
            } finally {
                lock.unlock();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                LOGGER.info("i am t2 thread");
            } finally {
                lock.unlock();
            }
        }, "t2");
        Thread t3 = new Thread(() -> {
            lock.lock();
            try {
                LOGGER.info("i am t3 thread");
            } finally {
                lock.unlock();
            }
        }, "t3");

        t1.start();
        Sleeps.seconds(1);
        t2.start();
        t3.start();
        LOGGER.info("main thread end");
    }

    public static void main(String[] args) {
        new CAS1_Main().test();
    }
}
