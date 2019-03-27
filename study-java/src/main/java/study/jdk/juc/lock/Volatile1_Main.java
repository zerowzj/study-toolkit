package study.jdk.juc.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

/**
 * 演示：不可见
 */
public class Volatile1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Volatile1_Main.class);

    class Task implements Runnable {

        private boolean running = true;

        int m;

        @Override
        public void run() {
            LOGGER.info("enter into task");
            while (running) {
                int a = 2;
                int b = 3;
                int c = a + b;
                m = c;
                //TODO 加上任意一个输出语句或者sleep方法你会发现死循环也会停止，不管isRunning变量是否被加上了上volatile关键字
                Sleeps.seconds(1);
//                LOGGER.info("i am print");
            }
            LOGGER.info("task is stopped");
        }

        public void stop() {
            running = false;
        }
    }

    void test() {
        Task task = new Task();
        Thread t = new Thread(task);
        t.start();

        Sleeps.seconds(1);
        LOGGER.info("stop task");
        task.stop();
    }

    public static void main(String[] args) {

    }
}
