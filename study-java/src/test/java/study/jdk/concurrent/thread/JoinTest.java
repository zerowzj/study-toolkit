package study.jdk.concurrent.thread;

import java.util.concurrent.TimeUnit;

public class JoinTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                sleep(5);
            }
        });
        t1.start();
        try {
            t1.join();
        } catch (Exception ex) {
        }
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                sleep(8);
            }
        });
        t2.start();
        try {
            t2.join();
        } catch (Exception ex) {
        }
        System.out.println("cost: " + (System.currentTimeMillis() - start) + " ms");
    }

    static void sleep(long time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (Exception ex) {
        }
    }
}
