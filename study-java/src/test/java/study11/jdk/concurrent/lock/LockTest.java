package study.jdk.juc.lock;

import study.Loggers;
import study.jdk.concurrent.SleepUtils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest implements Runnable {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
//        for (int i = 0; i < 2; i++) {
//            new Thread(new LockTask(lock))
//                    .start();
//        }

        Thread t1 = new Thread(new LockTest());
        Thread t2 = new Thread(new LockTest());
        t1.start();
        t2.start();
        SleepUtils.seconds(2);
        t2.interrupt();
    }

    @Override
    public void run() {
//        lock();
//        tryLock();
        lockInterruptibly();
    }

    /**
     *
     */
    public void lock() {
        lock.lock();
        try {
            Loggers.info(String.format("[%s]得到了锁", Thread.currentThread().getName()));
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception ex) {

        } finally {
            Loggers.info(String.format("[%s]释放了锁", Thread.currentThread().getName()));
            lock.unlock();
        }
    }

    /**
     *
     */
    public void tryLock() {
        if (lock.tryLock()) {
            try {
                Loggers.info(String.format("[%s]得到了锁", Thread.currentThread().getName()));
                SleepUtils.seconds(5);
            } finally {
                Loggers.info(String.format("[%s]释放了锁", Thread.currentThread().getName()));
                lock.unlock();
            }
        } else {
            Loggers.info(String.format("[%s]获取锁失败", Thread.currentThread().getName()));
        }
    }

    /**
     *
     */
    public void tryLock(long time) {

    }

    /**
     *
     */
    public void lockInterruptibly() {
        //注意，如果需要正确中断等待锁的线程，必须将获取锁放在外面，然后将InterruptedException抛出
        try {
            lock.lockInterruptibly();
            Loggers.info(String.format("[%s]得到了锁", Thread.currentThread().getName()));
            long startTime = System.currentTimeMillis();
            for (; ; ) {
                if (System.currentTimeMillis() - startTime >= Integer.MAX_VALUE)
                    break;
            }
        } catch (InterruptedException ex) {

        } finally {
            Loggers.info(String.format("[%s]执行finally", Thread.currentThread().getName()));
            lock.unlock();
            Loggers.info(String.format("[%s]释放了锁", Thread.currentThread().getName()));
        }
    }
}
