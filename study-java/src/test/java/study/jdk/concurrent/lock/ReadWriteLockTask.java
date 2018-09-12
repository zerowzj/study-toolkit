package study.jdk.concurrent.lock;

import study.Logger;
import study.jdk.concurrent.SleepUtils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class ReadWriteLockTask implements Runnable {

    private Lock lock;

    public ReadWriteLockTask(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
//        lock();
//        tryLock();
        lockInterruptibly();
    }

    public void lock() {
        lock.lock();
        try {
            Logger.info(String.format("[%s]得到了锁", Thread.currentThread().getName()));
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception ex) {

        } finally {
            Logger.info(String.format("[%s]释放了锁", Thread.currentThread().getName()));
            lock.unlock();
        }
    }

    public void tryLock() {
        if (lock.tryLock()) {
            try {
                Logger.info(String.format("[%s]得到了锁", Thread.currentThread().getName()));
                SleepUtils.second(5);
            } finally {
                Logger.info(String.format("[%s]释放了锁", Thread.currentThread().getName()));
                lock.unlock();
            }
        } else {
            Logger.info(String.format("[%s]获取锁失败", Thread.currentThread().getName()));
        }
    }

    public void tryLock(long time) {

    }

    public void lockInterruptibly() {
        //注意，如果需要正确中断等待锁的线程，必须将获取锁放在外面，然后将InterruptedException抛出
        try {
            lock.lockInterruptibly();

            Logger.info(String.format("[%s]得到了锁", Thread.currentThread().getName()));
            long startTime = System.currentTimeMillis();
            for (; ; ) {
                if (System.currentTimeMillis() - startTime >= Integer.MAX_VALUE)
                    break;
            }
        } catch (InterruptedException ex) {

        } finally {
            Logger.info(String.format("[%s]执行finally", Thread.currentThread().getName()));
            lock.unlock();
            Logger.info(String.format("[%s]释放了锁", Thread.currentThread().getName()));
        }
    }
}
