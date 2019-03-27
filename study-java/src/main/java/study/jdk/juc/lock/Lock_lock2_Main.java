package study.jdk.juc.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阻塞获取锁
 */
public class Lock_lock2_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Lock_lock2_Main.class);

    private Lock lock = new ReentrantLock();

    public void test() {
        Thread t = new Thread(() -> {
            lock.lock();
            try {
                LOGGER.info("i am thread t1");
            } finally {
                lock.unlock();
            }
        });
        t.start();

        Sleeps.seconds(2);
        t.interrupt();
        LOGGER.info("123123213");
    }

    public static void main(String[] args) {
        new Lock_lock2_Main().test();
    }
}
