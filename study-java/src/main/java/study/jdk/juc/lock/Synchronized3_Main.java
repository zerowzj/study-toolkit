package study.jdk.juc.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

/**
 * 异常退出
 */
public class Synchronized3_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Synchronized3_Main.class);

    private Object lock = new Object();

    void test() {

    }

    public static void main(String[] args) {
        new Synchronized3_Main().test();
    }
}
