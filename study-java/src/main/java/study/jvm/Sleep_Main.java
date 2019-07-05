package study.jvm;

import java.util.concurrent.TimeUnit;

/**
 * （1）sleep时线程堆栈信息
 */
public class Sleep_Main {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(Long.MAX_VALUE);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }, "t");
        t.start();
    }
}
