package study.jdk.juc.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

/**
 * 演示：守护线程
 */
public class Daemon1_Main {

    public static final Logger LOGGER = LoggerFactory.getLogger(Daemon1_Main.class);

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                LOGGER.info("i am thread t, sleep 2s");
                Sleeps.seconds(2);
            }
        });
        t.setDaemon(true);
        t.start();

        //线程t sleep 2s执行1次，main线程sleep 10s退出后，t退出
        LOGGER.info("i am thread main, sleep 10s");
        Sleeps.seconds(10);
    }
}
