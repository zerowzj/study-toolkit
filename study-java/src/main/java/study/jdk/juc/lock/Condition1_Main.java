package study.jdk.juc.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示：
 * （1）AQS
 */
public class Condition1_Main {

    public static final Logger LOGGER = LoggerFactory.getLogger(Condition1_Main.class);

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private void test() {
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                LOGGER.info("i am t1 thread");
                condition.await();
                LOGGER.info("t1 thread end");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            lock.tryLock();
            try {
                LOGGER.info("i am t2 thread");
                Sleeps.seconds(5);
                condition.signal();
            } finally {
                lock.unlock();
            }
        });

        //t1释放锁阻塞，t2持有锁执行完通知t1，t1收到通知继续执行
        t1.start();
        Sleeps.seconds(1);
        t2.start();
    }

    public static void main(String[] args) {
        new Condition1_Main().test();
    }
}
