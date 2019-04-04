package study.jdk.juc.aqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 可重入自旋锁
 */
public class ReentrantSpinLock {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReentrantSpinLock.class);

    private AtomicReference<Thread> cas = new AtomicReference<>();

    private int count;

    public void lock() {
        Thread current = Thread.currentThread();
        if (current == cas.get()) {
            count++;
            return;
        }
        //如果没获取到锁，则通过CAS自旋
        while (!cas.compareAndSet(null, current)) {
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        cas.compareAndSet(current, null);
    }
}
