package study.jdk.juc.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.Semaphore;

/**
 * Semaphore: 信号量
 * 演示：
 */
public class Semaphore2_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Semaphore2_Main.class);

    private static int tcount = 10;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < tcount; i++) {
            String tname = (i + 1) + "";
            Thread t = new Thread(() -> {
                try {
                    semaphore.acquire();
                    LOGGER.info("thread[{}] running start", tname);
                    Sleeps.seconds(2);
                    LOGGER.info("thread[{}] running end", tname);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
            t.start();
       }
    }
}
