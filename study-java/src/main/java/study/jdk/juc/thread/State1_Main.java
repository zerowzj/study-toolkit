
package study.jdk.juc.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * jstack
 */
public class State1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(State1_Main.class);

    private Object lock = new Object();

    public void test() {
        Thread t = new Thread(() -> {
            LOGGER.info("i am t thread");
            //
//            Sleeps.seconds(10);
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }, "ssssssssss");
        LOGGER.info("new(): {}", t.getState().name());
        t.start();
        LOGGER.info("start(): {}", t.getState().name());
    }

    public static void main(String[] args) {
        new State1_Main().test();
    }
}
