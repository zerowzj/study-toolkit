package study.jdk.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
//        for (int i = 0; i < 2; i++) {
//            new Thread(new LockTask(lock))
//                    .start();
//        }

        Thread t1 = new Thread(new LockTask(lock));
        Thread t2 = new Thread(new LockTask(lock));
        t1.start();
        t2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        t2.interrupt();
    }
}
