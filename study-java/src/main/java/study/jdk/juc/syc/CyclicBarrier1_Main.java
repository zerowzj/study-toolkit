package study.jdk.juc.syc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Randoms;
import study.Sleeps;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Cyclic: 循环
 * Barrier: 屏障
 * 演示：
 */
public class CyclicBarrier1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(CyclicBarrier1_Main.class);

    private static final int T_NUM = 10;

    /**
     *
     */
    class Runner implements Runnable {

        private String name;

        private CyclicBarrier barrier;

        private Runner(String name, CyclicBarrier barrier) {
            this.barrier = barrier;
            this.name = name;
        }

        @Override
        public void run() {
            Sleeps.seconds(Randoms.nextInt(10));
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

    public void test() {
        CyclicBarrier barrier = new CyclicBarrier(T_NUM);
        for (int i = 0; i < T_NUM; i++) {
            Thread t1 = new Thread(new Runner(String.format("%s号选手", i + 1), barrier));
            t1.start();
        }
    }

    public static void main(String[] args) {
        new CyclicBarrier1_Main().test();
    }
}
