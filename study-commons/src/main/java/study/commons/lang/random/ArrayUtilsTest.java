package study.commons.lang.random;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class ArrayUtilsTest {

    //add
    @Test
    public void add_test() {
        String[] strArr = ArrayUtils.EMPTY_STRING_ARRAY;
        for (int i = 0; i < 5; i++) {
            strArr = ArrayUtils.add(strArr, i + "");
        }
        System.out.println(strArr.length);
    }

    //isEmpty
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

    //toArray
    @Test
    public void toArray_test() {
        String[] strArr = ArrayUtils.toArray("", "");
        System.out.println(strArr);
    }
}
