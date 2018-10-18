package study.jdk.concurrent.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.lang.invoke.MethodHandles;
import java.util.concurrent.CountDownLatch;

/**
 * countdown: 倒数计秒
 * latch: 闭锁
 * 演示：CountDownLatch基本用法
 */
public class CountDownLatch1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            Sleeps.seconds(2);
            LOGGER.info("i am t1 thread");
            latch.countDown();
        });
        Thread t2 = new Thread(() -> {
            Sleeps.seconds(2);
            LOGGER.info("i am t2 thread");
            latch.countDown();
        });
        t1.start();
        t2.start();

        try {
            latch.await();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        LOGGER.info("i am main thread");
    }
}
