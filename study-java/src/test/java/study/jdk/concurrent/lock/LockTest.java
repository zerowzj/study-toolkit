package study.jdk.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new LockTask(lock))
                    .start();
        }
    }
}
