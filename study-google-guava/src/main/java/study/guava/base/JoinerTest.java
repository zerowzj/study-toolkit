package study.guava.base;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Map;

@Slf4j
public class JoinerTest {

    @Test
    public void skipNulls_test() {
        String[] array = new String[]{"a", null};
        String str = Joiner.on(",")
                .skipNulls()
                .join(array);
        log.info(str);
    }

    @Test
    public void useForNull_test() {
        String[] array = new String[]{"a", null};
        String str = Joiner.on(",")
                .useForNull("空值")
                .join(array);
        log.info(str);
    }

    @Test
    public void withKeyValueSeparator_test() {
        Map data = Maps.newHashMap();
        data.put("k1", "value1");
        data.put("k2", "value2");
        data.put("k3", "");
//        data.put("k4", null); //报错
        String str = Joiner.on("&")
//                .skipNulls() //报错
//                .useForNull("") //报错
                .withKeyValueSeparator("=")
                .join(data);
        log.info(str);
    }

    @Test
    public void append_test() {
        String str = Joiner.on(",")
//                .skipNulls() //报错
                .appendTo(new StringBuilder(), "aa", "bb")
                .toString();
        log.info(str);
    }
}
