package study.jdk.juc.aqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class SpinLock {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpinLock.class);

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
        LOGGER.info("unlock= {}", owner.compareAndSet(current, null));
    }
}
