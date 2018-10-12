package study.jdk.concurrent.thread;

import study.Loggers;
import study.Sleeps;

/**
 * 演示join原理
 */
public class Join1_Main {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Sleeps.seconds(2);
            Loggers.info("i am t thread");
        });
        t.start();
        try {
            t.join();
            /*synchronized (t) {
                t.wait();
            }*/
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        Loggers.info("i am main thread");
    }
}
