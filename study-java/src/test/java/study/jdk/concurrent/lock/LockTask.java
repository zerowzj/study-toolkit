package study.jdk.concurrent.lock;

import study.Logger;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class LockTask implements Runnable {

    private Lock lock;

    public LockTask(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
//        lock();
        tryLock();
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
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception ex) {

            } finally {
                Logger.info(String.format("[%s]释放了锁", Thread.currentThread().getName()));
                lock.unlock();
            }
        } else {
            Logger.info(String.format("[%s]获取锁失败", Thread.currentThread().getName()));
        }
    }

    public void tryLock(long time) {
        if (lock.tryLock(time, TimeUnit.SECONDS)) {
            try {
                Logger.info(String.format("[%s]得到了锁", Thread.currentThread().getName()));
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception ex) {

            } finally {
                Logger.info(String.format("[%s]释放了锁", Thread.currentThread().getName()));
                lock.unlock();
            }
        } else {
            Logger.info(String.format("[%s]获取锁失败", Thread.currentThread().getName()));
        }
    }
}
