package study.apache.commons.lang3;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
public class ArrayUtils_Test {

    @Test
    public void add_test() {
        String[] strArr = ArrayUtils.EMPTY_STRING_ARRAY;
        for (int i = 0; i < 5; i++) {
            strArr = ArrayUtils.add(strArr, i + 1 + "");
        }
        Arrays.asList(strArr).forEach(str -> {
            log.info(str);
        });
    }

    @Test
    public void isEmpty_test() {
        String[] strArr = new String[]{"1", "2"};
        System.out.println(ArrayUtils.isEmpty(strArr));
        System.out.println(ArrayUtils.isNotEmpty(strArr));
    }

    //subarray
    @Test
    public void subarray_test() {
        String[] strArr = new String[]{"1", "2"};
        System.out.println(ArrayUtils.subarray(strArr, 0, 1));
    }

    @Test
    public void toArray_test() {
        String[] strArr = ArrayUtils.toArray("aa", "bb", "cc");
    }
}
