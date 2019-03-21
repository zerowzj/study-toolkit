
package study.jdk.juc.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class State1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(State1_Main.class);

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            LOGGER.info("i am t thread");
        });
        LOGGER.info("new(): {}", t.getState().name());

        t.start();
        LOGGER.info("start(): {}", t.getState().name());
    }
}
