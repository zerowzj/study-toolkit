package study.guava.base;

import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.Map;

@Slf4j
public class SplitterTest {

    private String str = "aa,bb, cc,dd ,e e,    ";

    @Test
    public void trimResults_test() {
        List<String> lt = Splitter.on(",")
                .trimResults()
                .splitToList(str);
        log.info("111111111111{}", lt);
    }

    @Test
    public void omitEmptyStrings_test() {
        List<String> data = Splitter.on(",")
                .omitEmptyStrings()
                .splitToList(str);
        log.info("{}", data);
    }

    @Test
    public void withKeyValueSeparator_test() {
        String str = "key1=value1&key2=value2";
        Map<String, String> data = Splitter.on("&")
                .withKeyValueSeparator("=")
                .split(str);
        log.info("{}", data);
    }
}
