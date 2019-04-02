package study.jdk.juc.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 演示：线程池共享对象
 */
public class FixedThreadPool_2_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(FixedThreadPool_2_Main.class);

    //一个窗口一个线程
    private static final int WINDOW_NUM = 3;

    /**
     * 叫号机
     */
    private class Caller {

        private int no;

        public int getNo() {
            return ++no;
        }
    }

    /**
     * 窗口
     */
    private class Window implements Runnable {

        private String winNo;

        private Caller caller;

        public Window(String winNo, Caller caller) {
            this.winNo = winNo;
            this.caller = caller;
        }

        @Override
        public void run() {
            while (true) {
                int no;
                //同步
//                synchronized (caller) {
//                    no = caller.getNo();
//                }
                //临界区
                no = caller.getNo();
                LOGGER.info("请{}号到==>{}号窗口", no, winNo);
                Sleeps.seconds(3);
            }
        }
    }

    private void test() {
        ExecutorService pool = Executors.newFixedThreadPool(WINDOW_NUM);
        //叫号机
        Caller caller = new Caller();
        //线程池pool执行
        for (int i = 0; i < WINDOW_NUM; i++) {
            pool.execute(new Window(String.valueOf(i + 1), caller));
        }
        pool.shutdown();
    }

    public static void main(String[] args) {
        new FixedThreadPool_2_Main().test();
    }
}
