package study.jdk.juc.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阻塞获取锁
 */
public class Lock_lockInterruptibly_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Lock_lockInterruptibly_Main.class);

    private Lock lock = new ReentrantLock();

    public void test() {
        Thread t1 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
                LOGGER.info("i am thread t1");
                Sleeps.seconds(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                LOGGER.info("AAAAAAAAAAA");
            } finally {
                lock.unlock();
            }
        });
        t1.start();

        Sleeps.seconds(3);
        t1.interrupt();
        LOGGER.info("SSSSSSSS");
    }

    public static void main(String[] args) {
        new Lock_lockInterruptibly_Main().test();
    }
}
