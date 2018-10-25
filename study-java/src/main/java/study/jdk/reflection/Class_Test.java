package study.jdk.reflection;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Class_Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(Class_Test.class);

    int i = 1;
    Integer j = 2;

    @Test
    public void test_isInterface() {
        LOGGER.info("List.isInterface={}", List.class.isInterface());
        LOGGER.info("ArrayList.isInterface={}", ArrayList.class.isInterface());
    }

    @Test
    public void test_isArray() {
        LOGGER.info("List.isInterface={}", List.class.isInterface());
        LOGGER.info("ArrayList.isInterface={}", ArrayList.class.isInterface());
    }

    @Test
    public void test_isPrimitive() {
        LOGGER.info("List.isInterface={}", j.getClass().isPrimitive());
    }
}
