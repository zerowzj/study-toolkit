package study.jdk.juc.atomic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示：
 * （1）
 */
public class AtomicInteger1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(AtomicInteger1_Main.class);

    private static int THREAD_NUM = 100;

    private static int MAX_VALUE = 1000;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_NUM);
        AtomicInteger value = new AtomicInteger(0);
        for (int i = 0; i < THREAD_NUM; i++) {
            pool.execute(() -> {
                while (value.get() < MAX_VALUE) {
                    value.incrementAndGet();
                }
            });
        }
        Sleeps.seconds(8);
        LOGGER.info("value= {}", value.get());
        pool.shutdown();
    }
}
