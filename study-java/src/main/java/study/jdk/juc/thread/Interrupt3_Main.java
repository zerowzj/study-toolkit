package study.jdk.juc.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.TimeUnit;

/**
 * 阻塞方法中断
 */
public class Interrupt3_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Interrupt3_Main.class);

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (InterruptedException ex) {
                //ex.printStackTrace();
               // LOGGER.info("middle interrupt= {}", Thread.currentThread().isInterrupted());
            }
        });
        t.start();

        Sleeps.seconds(1);
        LOGGER.info("before interrupt= {}", t.isInterrupted());
        t.interrupt();
//        Sleeps.seconds(1);
        LOGGER.info("after interrupt= {}", t.isInterrupted());
    }
}
