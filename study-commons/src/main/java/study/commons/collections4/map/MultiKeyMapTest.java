package study.commons.collections4.map;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.junit.Test;

@Slf4j
public class MultiKeyMapTest {

    @Test
    public void test() {
        MultiKeyMap<String, String> map = new MultiKeyMap();
        map.put("key1", "key2", "123");
        log.info("key1={}, key2={}", map.get("key1", "key2"), map.get("key2"));
    }

    @Test
    public void test1() {
        MultiKeyMap<String, String> map = new MultiKeyMap();
        map.put("key1", "key2", "123");
        log.info("key1={}, key2={}", map.get("key1", "key2"), map.get("key2"));
    }
}