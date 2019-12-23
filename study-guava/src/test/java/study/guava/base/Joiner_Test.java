package study.guava.base;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class Joiner_Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(Joiner_Test.class);

    private static final String APP_DIR = System.getProperty("user.dir");

    private static final String KEY_ROOT_DIR = "config";

    String[] array = new String[]{"a", "b", "c", null};

    @Test
    public void skipNulls_test() {
        String str = Joiner.on(",")
                .skipNulls()
                .join(array);
        LOGGER.info("str={}", str);
    }

    @Test
    public void useForNull_test() {
        String str = Joiner.on(",")
                .useForNull("==")
                .join(array);
        LOGGER.info("str={}", str);
    }

    @Test
    public void withKeyValueSeparator_test() {
        Map data = Maps.newHashMap();
        data.put("key1", "value1");
        data.put("key2", "value2");
        String str = Joiner.on("&")
                .withKeyValueSeparator("=")
                .join(data);
        LOGGER.info("{}", str);
    }

    @Test
    public void append_test() {
        Map<String, String> param = Maps.newHashMap();
        param.put("key1", "key1");
        param.put("key2", "");
        param.put("key3", null);

        String str = Joiner.on("&").useForNull("").skipNulls().withKeyValueSeparator("=").join(param);
        LOGGER.info(str);
    }
}
