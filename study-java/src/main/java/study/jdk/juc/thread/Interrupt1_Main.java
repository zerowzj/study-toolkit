package study.jdk.juc.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.TimeUnit;

/**
 * 中断
 */
public class Interrupt1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Interrupt1_Main.class);

    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            try {
                LOGGER.info("sleep 20s");
                TimeUnit.SECONDS.sleep(20);
            } catch (InterruptedException ex) {
                LOGGER.info("===={}", new RuntimeException("被中断了"));
            }
            LOGGER.info("sleep over ");
        });
        t.start();

        Sleeps.seconds(5);
        t.interrupt();
    }
}
