package study.jdk.concurrent.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 *
 */
public class Volatile1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Volatile1_Main.class);

    private volatile int count = 0;

    public static void main(String[] args) {
        for (int j = 0; j < 10; j++) {
           new Volatile1_Main().show();
        }
    }

    private void show() {
        CountDownLatch latch = new CountDownLatch(2);
        Thread t1 = new Thread(() -> {
            addCount();
            latch.countDown();
        });
        Thread t2 = new Thread(() -> {
            addCount();
            latch.countDown();
        });
        t1.start();
        t2.start();

        try {
            latch.await();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        LOGGER.info("count= {}", count);
    }

    private synchronized void addCount() {
        for (int i = 0; i < 1000; i++) {
            count++;
        }
    }
}
