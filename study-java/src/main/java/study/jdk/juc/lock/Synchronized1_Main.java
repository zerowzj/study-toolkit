package study.jdk.juc.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

/**
 * 演示：
 */
public class Synchronized1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Synchronized1_Main.class);

    synchronized void a() {
        LOGGER.info("i am aaa");
        Sleeps.deep();
    }

    synchronized void b() {
        LOGGER.info("i am bbb");
    }

    void test() {
        Thread t1 = new Thread(() -> {
            a();
        });
        Thread t2 = new Thread(() -> {
            b();
        });

        t1.start();
        Sleeps.seconds(1);
        t2.start();
    }

    public static void main(String[] args) {
        new Synchronized1_Main().test();
    }
}
