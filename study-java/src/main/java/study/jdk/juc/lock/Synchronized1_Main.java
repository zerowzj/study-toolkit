package study.jdk.juc.lock;

/**
 *
 */
public class Synchronized1_Main {

    private Object lock = new Object();

    public void test() {
        Thread t1 = new Thread(() -> {
        });
        synchronized (lock) {
        }
    }

    public static void main(String[] args) {

    }
}
