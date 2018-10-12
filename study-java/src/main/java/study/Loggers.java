package study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class Loggers {

    private static final Logger LOGGER = LoggerFactory.getLogger("STDOUT");

    public static void info(String str, Object... objs) {
        LOGGER.info(str, objs);
    }
}
