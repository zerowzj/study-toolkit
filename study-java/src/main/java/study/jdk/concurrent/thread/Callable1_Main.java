package study.jdk.concurrent.thread;

import study.Loggers;
import study.Sleeps;

import java.util.concurrent.FutureTask;

public class Callable1_Main {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();

        FutureTask<Integer> task1 = new FutureTask(() -> {
            int sum = 10;
            Sleeps.seconds(3);
            Loggers.info("i am task1");
            return sum;
        });
        FutureTask<Integer> task2 = new FutureTask(() -> {
            int sum = 21;
            Sleeps.seconds(5);
            Loggers.info("i am task2");
            return sum;
        });
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
        try {
            Integer sum = task1.get() + task2.get();
            Loggers.info("sum= {}, cost time= {}ms", sum, (System.currentTimeMillis() - now));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Loggers.info("i am main thread");
    }
}
