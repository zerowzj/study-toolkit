package study.jdk.jcf.list;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class Arrays_Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(Arrays_Test.class);

    /**
     * 演示：
     */
    @Test
    public void test_asList() {
        List<String> data = Arrays.asList("a", "b");
        LOGGER.info("data={}", data);
    }

    /**
     * 演示：
     */
    @Test
    public void test_copyOf() {
        String[] original = new String[]{"a", "b", "c", "d"};
        int newLength = 9;
        String[] data = Arrays.copyOf(original, newLength);
        LOGGER.info("length={}", data.length);
        LOGGER.info("data={}", Arrays.asList(data));
    }
}
