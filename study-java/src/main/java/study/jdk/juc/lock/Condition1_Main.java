package study.jdk.juc.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示：
 */
public class Condition1_Main {

    public static final Logger LOGGER = LoggerFactory.getLogger(Condition1_Main.class);

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    void a() {
        lock.tryLock();
        try {
            LOGGER.info("i am method a()");
            Sleeps.seconds(10);
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    void b() {
        lock.lock();
        try {
            LOGGER.info("i am method b()");
            condition.await();
            LOGGER.info("method b() exe");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void test() {
        Thread t1 = new Thread(() -> {
            a();
        });
        Thread t2 = new Thread(() -> {
            b();
        });
        //t2无锁阻塞，t1持有锁执行完通知t2
        t2.start();
        Sleeps.seconds(1);
        t1.start();
    }

    public static void main(String[] args) {
        new Condition1_Main().test();
    }
}
