package study.commons.lang3;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

@Slf4j
public class ArrayUtils_Test {

    @Test
    public void add_test() {
        String[] strArr = ArrayUtils.EMPTY_STRING_ARRAY;
        for (int i = 0; i < 5; i++) {
            strArr = ArrayUtils.add(strArr, String.valueOf(i + 1));
        }
        for (String str : strArr) {
            log.info("{}", str);
        }
    }

    @Test
    public void isEmpty_test() {
        String[] strArr1 = new String[]{"1", "2"};
        String[] strArr2 = new String[]{"1", ""};
        String[] strArr3 = new String[]{"1", null};
        String[] strArr4 = new String[]{};
        log.info("{}", ArrayUtils.isEmpty(strArr1));
        log.info("{}", ArrayUtils.isEmpty(strArr2));
        log.info("{}", ArrayUtils.isEmpty(strArr3));
        log.info("{}", ArrayUtils.isEmpty(strArr4));
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
