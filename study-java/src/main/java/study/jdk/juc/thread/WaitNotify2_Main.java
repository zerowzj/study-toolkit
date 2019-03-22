package study.jdk.juc.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

/**
 * 一个线程计算
 */
public class WaitNotify2_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(WaitNotify2_Main.class);

    private static int sum = 0;

    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                for (; ; ) {
                    sum = sum + 100;
                    Sleeps.milliseconds(500);
                    LOGGER.info("==>{}", sum);
                    if (sum == 500) {
                        LOGGER.info("t1 notify start");
                        lock.notify();
                        LOGGER.info("t1 notify end");
                        //TODO 去掉break，notify只通知t2但不释放锁，t2无法再wait()方法处返回
                        break;
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    LOGGER.info("t2 wait start");
                    lock.wait();
                    LOGGER.info("t2 wait end");
                    LOGGER.info("t2 sum= {}", sum);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        //TODO t2需要先执行并且紧跟着要sleep一下保证其充分启动
        t2.start();
        Sleeps.seconds(1);
        t1.start();
    }
}
