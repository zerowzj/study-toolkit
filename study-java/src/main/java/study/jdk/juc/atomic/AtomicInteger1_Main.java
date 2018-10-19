package study.jdk.juc.atomic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicInteger1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(AtomicInteger1_Main.class);

    private static int TIMES = 1000;

    private static AtomicInteger atomicCount = new AtomicInteger(0);

    private static Integer count = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            count();
            safeCount();
        });
        Thread t2 = new Thread(() -> {
            count();
            safeCount();
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
        }
        LOGGER.info("count= {}", count);
        LOGGER.info("atomicCount= {}", atomicCount);
    }

    private static void count() {
        for (int i = 0; i < TIMES; i++) {
            count++;
        }
    }

    private static void safeCount() {
        for (int i = 0; i < TIMES; i++) {
            atomicCount.incrementAndGet();
        }
    }
}
