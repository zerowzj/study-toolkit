package study.jdk.juc.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

/**
 * 演示：volatile保证可见性
 */
public class Volatile2_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Volatile2_Main.class);

    public static void main(String[] args) {
        Task task = new Volatile2_Main().new Task();
        Thread t = new Thread(task);
        t.start();

        Sleeps.seconds(1);
        LOGGER.info("stop task");
        task.stop();
    }

    class Task implements Runnable {

        private volatile boolean running = true;

        int m;

        @Override
        public void run() {
            LOGGER.info("enter into task");
            while (running) {
                int a = 2;
                int b = 3;
                int c = a + b;
                m = c;
            }
            LOGGER.info("task is stopped");
        }

        public void stop() {
            running = false;
        }
    }
}
