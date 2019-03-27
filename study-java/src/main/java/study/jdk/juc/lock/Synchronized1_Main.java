package study.jdk.juc.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

/**
 *
 */
public class Synchronized1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Synchronized1_Main.class);

    private Object lock = new Object();

    public void test() {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                LOGGER.info("i am thread t1");

            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock){
                LOGGER.info("i am thread t2");
            }
        });

        t1.start();
        Sleeps.seconds(1);
        t1.interrupt();
        t2.start();
    }

    public static void main(String[] args) {
        new Synchronized1_Main().test();
    }
}
