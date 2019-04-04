package study.jdk.juc.aqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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

            }
        }

        public void unlock() {
            Thread current = Thread.currentThread();
            owner.compareAndSet(current, null);
        }
    }

    private void test() {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        SpinLock lock = new SpinLock();
        for (int i = 0; i < 2; i++) {
            int taskNo = i + 1;
            pool.execute(() -> {
                lock.lock();
                try {
                    LOGGER.info("i am task[{}]", taskNo);
                    Sleeps.seconds(5);
                    LOGGER.info("task[{}] end", taskNo);
                } finally {
                    lock.unlock();
                }
            });
        }
        pool.shutdown();
        LOGGER.info("main thread end");
    }

    public static void main(String[] args) {
        new CAS1_Main().test();
    }
}
