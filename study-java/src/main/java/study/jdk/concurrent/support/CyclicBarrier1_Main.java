package study.jdk.concurrent.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Cyclic: 循环
 * Barrier: 屏障
 * 演示：CountDownLatch基本用法
 */
public class CyclicBarrier1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(CyclicBarrier1_Main.class);

    public static void main(String[] args) {
        int t = 5;
        CyclicBarrier barrier = new CyclicBarrier(t);
        for (int i = 0; i < t; i++) {
            Thread t1 = new Thread(new CyclicBarrier1_Main().new Runner(barrier, (i + 1) + "号选手"));
            t1.start();
        }
    }

    class Runner implements Runnable {

        private CyclicBarrier barrier;

        private String name;

        private Runner(CyclicBarrier barrier, String name) {
            this.barrier = barrier;
            this.name = name;
        }

        @Override
        public void run() {
            LOGGER.info("[{}] ready", name);
            try {
                barrier.await();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (BrokenBarrierException ex) {
                ex.printStackTrace();
            }
            LOGGER.info("[{}] running", name);
        }
    }
}
