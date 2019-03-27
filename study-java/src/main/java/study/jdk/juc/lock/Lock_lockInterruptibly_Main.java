package study.jdk.juc.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示：阻塞获取锁且可中断
 */
public class Lock_lockInterruptibly_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Lock_lockInterruptibly_Main.class);

    private Lock lock = new ReentrantLock();

    public void test() {
        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                LOGGER.info("i am thread t1");
                Sleeps.deep();
            } finally {
                lock.unlock();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
                LOGGER.info("i am thread t2");
            } catch (InterruptedException ex) {
               LOGGER.info("i am interrupt");
            } finally {
                LOGGER.info("code in finally");
                lock.unlock();
            }
            LOGGER.info("code after finally ");
        });
        t1.start();
        Sleeps.seconds(1);
        t2.start();

        //main线程中断t2
        Sleeps.seconds(3);
        t2.interrupt();
    }

    public static void main(String[] args) {
        new Lock_lockInterruptibly_Main().test();
    }
}
