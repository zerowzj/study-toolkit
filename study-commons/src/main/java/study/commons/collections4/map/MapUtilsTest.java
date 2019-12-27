package study.commons.collections4.map;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MapUtilsTest {

    @Test
    public void getString_test() {
        Map<String, Object> map = new HashMap<>();
        map.put("str", "safsafd");
        map.put("i", 123123);
        String str = MapUtils.getString(map, "i");
        log.info(str);
    }

    @Test
    public void getMap_test() {
        Map<String, Object> map = new HashMap<>();
        map.put("str", "safsafd");
        map.put("i", 123123);
        Map obj = MapUtils.getMap(map, "i");
    }

    @Test
    public void getObject_test() {
        Map<String, Object> map = new HashMap<>();
        map.put("str", "safsafd");
        map.put("i", 123123);
        Map obj = MapUtils.getMap(map, "i");
    }

    @Test
    public void isEmpty_test() {
        Map map1 = null;
        boolean a = MapUtils.isEmpty(map1);
        log.info("{}", a);

        Map map2 = new HashMap<>();
        boolean b = MapUtils.isEmpty(map2);
        log.info("{}", b);
    }
    @Test
    public void isNotEmpty_test() {
        Map map1 = null;
        boolean a = MapUtils.isNotEmpty(map1);
        log.info("{}", a);

        Map map2 = new HashMap<>();
        boolean b = MapUtils.isNotEmpty(map2);
        log.info("{}", b);
    }

    @Test
    public void emptyIfNull_test() {
        Map<String, Object> map = null;
        Map newMap = MapUtils.emptyIfNull(map);
        newMap.forEach((key, value) -> {
            log.info("{}={}", key, value);
        });
    }
}
