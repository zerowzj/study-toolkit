package study.jdk.juc.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * wait()与sleep()：两者都释放cpu；前者释放锁，后者不释放锁
 */
public class Sleep_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sleep_Main.class);

    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                //TODO 不释放锁
//                Sleeps.seconds(20);
                try {
                    //TODO 释放锁
                    lock.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                LOGGER.info("i am thread t2");
            }
        });

        t1.start();
        t2.start();
    }
}
