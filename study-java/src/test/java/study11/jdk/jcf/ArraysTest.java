package study.jdk.jcf;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ArraysTest {

    @Test
    public void asList_test() {
        List<String> list = Arrays.asList("a", "b", "c");
        System.out.println(list);
    }

    @Test
    public void copyOf_test() {
        String[] arr = new String[4];
        arr[0] = "1";
        arr[1] = "2";

        arr = Arrays.copyOf(arr, 2);
        System.out.println(arr.length);
    }
}
