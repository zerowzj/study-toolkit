package study.jdk.juc.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 演示：返回值的异步执行
 */
public class Callable1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Callable1_Main.class);

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        FutureTask<Integer> task1 = new FutureTask(() -> {
            Sleeps.seconds(3);
            LOGGER.info("i am task1");
            return 10;
        });
        FutureTask<Integer> task2 = new FutureTask(() -> {
            Sleeps.seconds(5);
            LOGGER.info("i am task2");
            return 21;
        });
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();

        try {
            Integer sum = task1.get() + task2.get();
            LOGGER.info("sum= {}, cost_time= {} ms", sum, (System.currentTimeMillis() - now));
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
        LOGGER.info("main thread end");
    }
}
