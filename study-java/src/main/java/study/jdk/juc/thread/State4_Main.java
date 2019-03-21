
package study.jdk.juc.thread;

/**
 *
 */
public class State4_Main {

    public static void main(String[] args) {
        Object lock = new Object();
        Thread t = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }, "ssssssssss");
        t.start();
    }
}
