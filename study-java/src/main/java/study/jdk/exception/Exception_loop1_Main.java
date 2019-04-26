package study.jdk.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Randoms;
import study.Sleeps;

/**
 * 演示：循环体内未捕获异常，终止循环
 */
public class Exception_loop1_Main {

    public static final Logger LOGGER = LoggerFactory.getLogger(Exception_loop1_Main.class);

    public static void main(String[] args) {
        for (; ; ) {
            int random = Randoms.nextInt(10);
            if (random == 0) {
                throw new RuntimeException("random is 0");
            }
            LOGGER.info("random={}, sleep 2s", random);
            Sleeps.seconds(2);
        }
    }
}
