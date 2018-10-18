package study.jdk.concurrent.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.Semaphore;

public class Semaphore1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Semaphore1_Main.class);

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        Thread t1 = new Thread(() -> {
            try {
                semaphore.acquire();
                LOGGER.info("i am t1 thread");
                Sleeps.seconds(3);
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
            } catch (InterruptedException ex) {
            } finally {
                semaphore.release();
            }
        });

        t1.start();
        t2.start();
    }
}
