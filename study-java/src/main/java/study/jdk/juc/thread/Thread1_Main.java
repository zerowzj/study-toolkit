package study.jdk.juc.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

/**
 *
 */
public class Thread1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Thread1_Main.class);

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            LOGGER.info("i am t thread");
            //Sleeps.seconds(2);
        });
        t.start();
        Sleeps.seconds(3);
        LOGGER.info("i am main thread");
    }
}
