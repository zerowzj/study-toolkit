package study.jdk.juc.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 非阻塞获取锁
 */
public class Lock_tryLock_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Lock_tryLock_Main.class);

    private Lock lock = new ReentrantLock();

    void test() {
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                LOGGER.info("i am thread t1 ");
                Sleeps.deep();
            } finally {
                lock.unlock();
            }
        });
        Thread t2 = new Thread(() -> {
            if (lock.tryLock()) {
                try {

                } finally {
                    lock.unlock();
                }
            } else {
                LOGGER.info("not get lock");
            }
        });

        t1.start();
        Sleeps.seconds(1);
        t2.start();
    }

    public static void main(String[] args) {
        new Lock_tryLock_Main().test();
    }
}
