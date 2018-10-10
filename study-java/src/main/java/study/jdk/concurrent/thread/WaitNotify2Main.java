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
                    if (sum == 2000) {
                        System.out.println("t1 notify start");
                        lock.notify();
                        System.out.println("t1 notify end");
                        //TODO 去掉break，notify只通知t2但不释放锁
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
        //TODO t2需要先执行并且紧跟着要sleep一下保证其充分启动
        t2.start();
        Sleeps.seconds(1);
        t1.start();
    }
}
