package study.jdk.juc.atomic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示：
 * （1）incrementAndGet()方法线程安全
 * （2）get()方法线程不安全
 */
public class AtomicInteger1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(AtomicInteger1_Main.class);

    private static int THREAD_NUM = 1000;

    private static int MAX_VALUE = 1000;

    private void a(AtomicInteger value) {
        while (value.get() < MAX_VALUE) {
            value.incrementAndGet();
        }
    }

    private void aa(AtomicInteger value) {
        synchronized (this) {
            while (value.get() < MAX_VALUE) {
                value.incrementAndGet();
            }
        }
    }

    private void b(AtomicInteger value) {
        for (int i = 0; i < MAX_VALUE; i++) {
            value.incrementAndGet();
        }
    }

    private void test() {
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_NUM);
        AtomicInteger value = new AtomicInteger(0);
        CountDownLatch latch = new CountDownLatch(THREAD_NUM);
        for (int i = 0; i < THREAD_NUM; i++) {
            pool.execute(() -> {
                a(value);
                latch.countDown();
            });
        }
        try {
            latch.await();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        LOGGER.info("value= {}", value.get());
        pool.shutdown();

    }

    public static void main(String[] args) {
        new AtomicInteger1_Main().test();
    }
}
