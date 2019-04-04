package study.jdk.juc.aqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 演示：
 * （1）
 * （2）
 * （3）
 */
public class AQS1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(AQS1_Main.class);

    public class Mutex {

        /**
         * 自定义同步器
         */
        class Sync extends AbstractQueuedSynchronizer {

            //是否处于占用状态
            @Override
            protected boolean isHeldExclusively() {
                return getState() == 1;
            }

            //当状态为0的时候获取锁，CAS操作成功，则state状态为1，
            @Override
            protected boolean tryAcquire(int acquires) {
                if (compareAndSetState(0, 1)) {
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
                return false;
            }

            //释放锁，将同步状态置为0
            @Override
            protected boolean tryRelease(int acquires) {
                if (getState() == 0)
                    throw new IllegalMonitorStateException();
                setExclusiveOwnerThread(null);
                setState(0);
                return true;
            }

            @Override
            protected int tryAcquireShared(int arg) {
                throw new UnsupportedOperationException();
            }

            @Override
            protected boolean tryReleaseShared(int arg) {
                throw new UnsupportedOperationException();
            }
        }

        private Sync sync = new Sync();

        public void lock() {
            sync.acquire(1);
        }

        public void unlock() {
            sync.release(1);
        }
    }

    private void test() {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Mutex lock = new Mutex();
        for (int i = 0; i < 3; i++) {
            int taskNo = i + 1;
            pool.execute(() -> {
//                lock.lock();
                try {
                    LOGGER.info("task[{}] start", taskNo);
                    Sleeps.seconds(5);
                    LOGGER.info("task[{}] end", taskNo);
                } finally {
//                    lock.unlock();
                }
            });
        }
        pool.shutdown();
        LOGGER.info("main thread end");
    }

    public static void main(String[] args) {

    }
}
