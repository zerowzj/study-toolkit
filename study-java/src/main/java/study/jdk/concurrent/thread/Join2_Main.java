package study.jdk.concurrent.thread;

import study.Loggers;
import study.Sleeps;

/**
 * 演示阻塞当前线程
 */
public class Join2_Main {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Sleeps.seconds(2);
            Loggers.info("i am t1 thread");
        });
        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            Loggers.info("i am t2 thread");
        });
        t1.start();
        t2.start();
        Loggers.info("i am main thread");
    }
}
