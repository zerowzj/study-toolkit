
package study.jdk.juc.thread;

import study.Sleeps;

/**
 *
 */
public class State3_Main {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Sleeps.seconds(Integer.MAX_VALUE);
        }, "ssssssssss");
        t.start();

        try {
            t.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
