package study.guava.str;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Map;

@Slf4j
public class JoinerTest {

    private static final String APP_DIR = System.getProperty("user.dir");

    private static final String KEY_ROOT_DIR = "config";

    String[] array = new String[]{"a", "b", "c", null};

    @Test
    public void skipNulls_test() {
        String str = Joiner.on(",")
                .skipNulls()
                .join(array);
        log.info("str={}", str);
        log.info("sssssssssssss");
    }

    @Test
    public void useForNull_test() {
        String str = Joiner.on(",")
                .useForNull("==")
                .join(array);
    }

    @Test
    public void withKeyValueSeparator_test() {
        Map data = Maps.newHashMap();
        data.put("key1", "value1");
        data.put("key2", "value2");
        String str = Joiner.on("&")
                .withKeyValueSeparator("=")
                .join(data);
        log.info("{}", str);
    }

    @Test
    public void append_test() {
        Map<String, String> param = Maps.newHashMap();
        param.put("key1", "key1");
        param.put("key2", "");
        param.put("key3", null);

        String str = Joiner.on("&").useForNull("").skipNulls().withKeyValueSeparator("=").join(param);
        log.info(str);
    }
}
