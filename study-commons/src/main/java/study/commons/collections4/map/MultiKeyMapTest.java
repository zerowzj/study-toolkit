package study.commons.collections4.map;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.junit.Test;

@Slf4j
public class MultiKeyMapTest {

    @Test
    public void get_test() {
        MultiKeyMap<String, String> map = new MultiKeyMap();
        MultiKey multiKey = new MultiKey("key1", "key2");
        map.put(multiKey, "value");

        log.info("key1={}", map.get("key1")); //null
        log.info("key2={}", map.get("key3")); //null
        log.info("[key1, key2]={}", map.get(multiKey)); //value
    }
}