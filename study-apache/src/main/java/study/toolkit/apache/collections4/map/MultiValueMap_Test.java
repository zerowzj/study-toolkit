package study.toolkit.apache.collections4.map;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class MultiValueMap_Test {

    @Test
    public void test() {
        ArrayListValuedHashMap<String, String> map = new ArrayListValuedHashMap();
        map.put("key", "abc");
        map.put("key", "123");
        List<String> values = map.get("key");
        values.forEach(str -> {
            log.info(str);
        });
    }

    @Test
    public void putAll_test() {
        ArrayListValuedHashMap<String, String> map = new ArrayListValuedHashMap();
        map.putAll("key", Arrays.asList("abc", "123", "!@#"));
        List<String> values = map.get("key");
        values.forEach(str -> {
            log.info(str);
        });
    }
}
