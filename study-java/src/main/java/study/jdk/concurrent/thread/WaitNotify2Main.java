package study.jdk.concurrent.thread;

public class WaitNotify2Main {

    private static int sum = 0;

    public static void main(String[] args) {

        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                for (; ; ) {
                    sum++;
                    if (sum == 1000) {
                        lock.notify();
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println(sum);
        });
        t1.start();
        t2.start();
    }
}
