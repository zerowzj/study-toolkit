package study.jdk.juc.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

/**
 * 中断
 */
public class Interrupt1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Interrupt1_Main.class);

    private static Object lock = new Object();

    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            try {
//                LOGGER.info("sleep 10s");
//                TimeUnit.SECONDS.sleep(20);

                synchronized (lock) {
                    LOGGER.info("i am waiting");
                    lock.wait();
                }
            } catch (InterruptedException ex) {
                LOGGER.info("", new RuntimeException("i am interrupted"));
            }
            LOGGER.info("after interrupt exception");
        });
        t.start();

        Sleeps.seconds(5);
        t.interrupt();
        LOGGER.info("interrupt over");
    }
}
