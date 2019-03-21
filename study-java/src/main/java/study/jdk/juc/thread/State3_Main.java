
package study.jdk.juc.thread;

/**
 * jps
 * jstack <pid>
 */
public class State3_Main {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
        }, "ssssssssss");
        t.start();
    }
}
