package study.jdk.juc.thread;

import study.Loggers;
import study.Sleeps;

/**
 *
 */
public class WaitNotify2_Main {

    private static int sum = 0;

    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                for (; ; ) {
                    sum = sum + 100;
                    Sleeps.milliseconds(500);
                    Loggers.info("==>{}", sum);
                    if (sum == 500) {
                        Loggers.info("t1 notify start");
                        lock.notify();
                        Loggers.info("t1 notify end");
                        //TODO 去掉break，notify只通知t2但不释放锁，t2无法再wait()方法处返回
                        break;
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    Loggers.info("t2 wait start");
                    lock.wait();
                    Loggers.info("t2 wait end");
                    Loggers.info("t2 sum= {}", sum);
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
