package study.toolkit.apache.collections4.map;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Slf4j
public class MapUtils_Test {

    /**
     * （★）getXXX()
     */
    @Test
    public void getString_test() {
        Map map = new HashMap<>();
        map.put("name", "wangzhj");
        map.put("age", 38);
        String name = MapUtils.getString(map, "name");
        int age = MapUtils.getInteger(map, "age");
        String ageStr = MapUtils.getString(map, "age");
        log.info("{}, {}, {}", name, age, ageStr);
    }

    @Test
    public void getMap_test() {
        Map map = new HashMap<>();
        map.put("name", "wangzhj");
        Map newMap = MapUtils.getMap(map, "name");
        log.info("{}", newMap);
    }

    @Test
    public void getObject_test() {
        Map map = new HashMap<>();
        map.put("name", "wangzhj");
        Object obj = MapUtils.getObject(map, "name");
        log.info("{}", obj);
    }

    /**
     * （★）isEmpty() & isNotEmpty()
     */
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

    /**
     * （★）emptyIfNull()
     */
    @Test
    public void emptyIfNull_test() {
        Map<String, Object> map = null;
        Map newMap = MapUtils.emptyIfNull(map);
        newMap.forEach((key, value) -> {
            log.info("{}={}", key, value);
        });
    }

    /**
     * （★）toXXX()
     */
    @Test
    public void toProperties_test() {
        Map<String, Object> map = new HashMap<>();
        map.put("demo.name", "wangzhj");
        map.put("demo.age", 3);
        Properties prop = MapUtils.toProperties(map);
        prop.forEach((key, value) -> {
            log.info("{}={}", key, value);
        });
    }

    @Test
    public void toMap_test() {
        Properties prop = new Properties();
        prop.setProperty("demo.name", "wangzhj");
        prop.setProperty("demo.age", "33");
//        Map newMap = MapUtils.toMap(new PropertyResourceBundle(prop));

    }
}
