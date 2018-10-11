package study.jdk.concurrent.thread;

/**
 * 输出结果：
 *
 * 
 */
public class WaitNotify1_Main {

    static Object lock = new Object();

    public static void main(String[] args) {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                        System.out.println("A 1");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("A 2");
                        System.out.println("A 3");
                    }
            }
        });

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("B 1");
                    System.out.println("B 2");
                    System.out.println("B 3");

                    lock.notify();
                }
            }
        });
        A.start();
        B.start();
    }
}
