package study.jdk.juc.aqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

/**
 * 演示：
 */
public class SpinLock1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpinLock1_Main.class);

    public static void main(String[] args) {
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
                Sleeps.seconds(5);
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
}
