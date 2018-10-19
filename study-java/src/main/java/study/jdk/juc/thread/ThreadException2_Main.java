package study.jdk.juc.thread;

import study.Loggers;
import study.Sleeps;

/**
 * 异常后线程继续执行
 */
public class ThreadException2_Main {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            int i = 0;
            for (; ; ) {
                i++;
                try {
                    Sleeps.milliseconds(500);
                    Loggers.info("==>{}", i);
                    if (i == 10) {
                        throw new NullPointerException();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        t.start();
    }
}
