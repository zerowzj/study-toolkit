package study.guava.base;

import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.Map;

@Slf4j
public class SplitterTest {

    @Test
    public void trimResults_test() {
        String str = " aa,bb ,c c,, ,   ,dd";
        List<String> strLt = Splitter.on(",")
                .trimResults()
                .splitToList(str);
        strLt.forEach(data -> {
            log.info("[{}]", data);
        });
    }

    @Test
    public void omitEmptyStrings_test() {
        String str = "aa,, ,   ,bb";
        List<String> strLt = Splitter.on(",")
                .omitEmptyStrings()
                .splitToList(str);
        strLt.forEach(data -> {
            log.info("[{}]", data);
        });
    }

    @Test
    public void withKeyValueSeparator_test() {
        String str = "key1=value1&key2=value2&key3=value3";
        Map<String, String> data = Splitter.on("&")
                .withKeyValueSeparator("=")
                .split(str);
        data.forEach((k, v) -> {
            log.info("{}={}", k, v);
        });
    }

    @Test
    public void test() {
        String str = "101,1,六年级|102,1,七年级|201,2,高一|202,2,高二";
        List<String> strLt = Splitter.on("|").splitToList(str);
        strLt.forEach(data -> {
            List<String> t = Splitter.on(",").splitToList(data);
            log.info("{}={}={}", t.get(0), t.get(1), t.get(2));
        });
    }
}
