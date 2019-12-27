package study.commons.collections4.map;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.Test;

import java.util.List;

@Slf4j
public class MultiValueMapTest {

    @Test
    public void test() {
        ArrayListValuedHashMap<String, String> map = new ArrayListValuedHashMap();
        map.put("key", "12312");
        map.put("key", "abdsfdds");
        List<String> values = map.get("key");
        values.forEach(str -> {
            log.info(str);
        });
    }
}
