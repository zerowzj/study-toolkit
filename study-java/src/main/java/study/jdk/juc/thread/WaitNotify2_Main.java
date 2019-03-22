package study.jdk.juc.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

/**
 * 一个线程计算
 */
public class WaitNotify2_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(WaitNotify2_Main.class);

    private int sum = 0;

    public void test() {
        Object lock = new Object();
        //计算线程
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                for (; ; ) {
                    sum += 100;
                    Sleeps.seconds(1);
                    LOGGER.info("==>{}", sum);
                    if (sum == 500) {
                        LOGGER.info("t1 notify start");
                        lock.notify(); //仅仅
                        LOGGER.info("t1 notify end");
                        //去掉break，notify只通知t2但不释放锁，t2无法再wait()方法处返回
                        //TODO 保证跳出for循环，执行notify()，不会跳出循环
                        break;
                    }
                }
            }
        });
        //输出线程
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
        //t2 需要先执行并且紧跟着要sleep一下保证其充分启动
        t2.start();
        Sleeps.seconds(1);
        t1.start();
    }

    public static void main(String[] args) {
        new WaitNotify2_Main().test();
    }
}
