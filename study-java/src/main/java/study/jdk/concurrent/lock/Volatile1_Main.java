package study.jdk.concurrent.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

public class Volatile1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Volatile1_Main.class);

    private volatile static int count = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            addCount();
        });
        Thread t2 = new Thread(() -> {
            addCount();
        });
        t1.start();
        t2.start();
        Sleeps.seconds(5);

        LOGGER.info("count= {}", count);
    }

    private static void addCount() {
        for (int i = 0; i < 1000; i++) {
            count++;
        }
    }
}
