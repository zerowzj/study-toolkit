
package study.jdk.juc.thread;

import study.Sleeps;

/**
 * jps
 * jstack <pid>
 */
public class State2_Main {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Sleeps.seconds(Integer.MAX_VALUE);
        }, "ssssssssss");
        t.start();
    }
}
