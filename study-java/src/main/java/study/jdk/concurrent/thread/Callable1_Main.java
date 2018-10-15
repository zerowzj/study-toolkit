package study.jdk.concurrent.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Loggers;
import study.Sleeps;

import java.lang.invoke.MethodHandles;
import java.util.concurrent.FutureTask;

public class Callable1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        long now = System.currentTimeMillis();

        FutureTask<Integer> task1 = new FutureTask(() -> {
            int sum = 10;
            Sleeps.seconds(3);
            LOGGER.info("i am task1");
            return sum;
        });
        FutureTask<Integer> task2 = new FutureTask(() -> {
            int sum = 21;
            Sleeps.seconds(5);
            LOGGER.info("i am task2");
            return sum;
        });
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
        try {
            Integer sum = task1.get() + task2.get();
            LOGGER.info("sum= {}, cost time= {}ms", sum, (System.currentTimeMillis() - now));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        LOGGER.info("i am main thread");
    }
}
