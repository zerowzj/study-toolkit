package study.jdk.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 演示：循环体内捕获异常，循环继续
 */
public class Exception_loop2_Main {

    public static final Logger LOGGER = LoggerFactory.getLogger(Exception_loop2_Main.class);

    public static void main(String[] args) {
        Exception_loop1_Main main = new Exception_loop1_Main();
        for (; ; ) {
            try {
                main.test();
            } catch (Exception ex) {
                LOGGER.info("loop exception");
            }
        }
    }
}
