package study.commons.collections;

import org.apache.commons.collections4.MapUtils;
import org.junit.Test;

import java.util.Map;

public class MapUtilsTest {

    @Test
    public void isEmpty_test() {
        Map map = null;
        System.out.println(MapUtils.isEmpty(map));
        System.out.println(MapUtils.isNotEmpty(map));
    }
}
