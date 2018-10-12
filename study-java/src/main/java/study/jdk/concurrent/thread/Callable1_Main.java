package study.jdk.concurrent.thread;

import study.Loggers;
import study.Sleeps;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class Callable1_Main {

    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask(() -> {
            int sum = 10;
            Sleeps.seconds(3);
            Loggers.info("i am task");
            return sum;
        });
        Thread t = new Thread(task);
        t.start();
        try {
            Integer sum = task.get(4, TimeUnit.SECONDS);
            Loggers.info("sum= {}", sum);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Loggers.info("i am main thread");
    }
}
