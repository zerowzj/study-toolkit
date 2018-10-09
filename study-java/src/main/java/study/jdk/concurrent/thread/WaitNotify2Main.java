package study.jdk.concurrent.thread;

import study.Sleeps;

public class WaitNotify2Main {

    private static int sum = 0;

    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                for (; ; ) {
                    sum = sum + 100;
                    //Sleeps.seconds(1);
                    System.out.println("==>" + sum);
                    if (sum == 1000) {
                        System.out.println("t1 notify start");
                        lock.notify();
                        System.out.println("t1 notify end");
                        //TODO 去掉break
                        break;
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("t2 wait start");
                    lock.wait();
                    System.out.println("t2 sum= " + sum);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        t2.start();
        Sleeps.seconds(1);
        t1.start();
    }
}
