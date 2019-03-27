package study.jdk.juc.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

/**
 * 不可中断
 */
public class Synchronized2_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Synchronized2_Main.class);

    private Object lock = new Object();

    void test() {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                LOGGER.info("i am thread t1");
                Sleeps.deep();
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                LOGGER.info("i am thread t2");
            }
        });
        t1.start();
        Sleeps.seconds(1);
        t2.start();

        //main线程中断t2
        Sleeps.seconds(3);
        t2.interrupt();
    }

    public static void main(String[] args) {
        new Synchronized2_Main().test();
    }
}
