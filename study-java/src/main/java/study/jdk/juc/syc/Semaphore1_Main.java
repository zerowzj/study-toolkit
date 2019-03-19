package study.jdk.juc.syc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.Semaphore;

/**
 * Semaphore: 信号量
 * 演示：
 */
public class Semaphore1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Semaphore1_Main.class);

    public static void main(String[] args) {
        //permits: 初始化可用的许可数目。
        //   fair: 若该信号量保证在征用时按FIFO的顺序授予许可，则为true，否则为false；
        Semaphore semaphore = new Semaphore(2);
        Thread t1 = new Thread(() -> {
            try {
                semaphore.acquire();
                LOGGER.info("i am t1 thread");
                Sleeps.seconds(3);
                LOGGER.info("i am t1 thread");
            } catch (InterruptedException ex) {
            } finally {
                semaphore.release();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                semaphore.acquire();
                LOGGER.info("i am t2 thread");
                Sleeps.seconds(3);
                LOGGER.info("i am t2 thread");
            } catch (InterruptedException ex) {
            } finally {
                semaphore.release();
            }
        });

        t1.start();
        t2.start();
    }
}
