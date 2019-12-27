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
}
