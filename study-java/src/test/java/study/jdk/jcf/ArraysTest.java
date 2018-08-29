package study.jdk.jcf;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class ArraysTest {

    //
    @Test
    public void asList_test() {
        List<String> list = Arrays.asList("", "", "");
    }

    @Test
    public void copyOf_test(){
        String[] arr = new String[4];
        arr[0] = "1";
        arr[1] = "2";
        String clazz = arr.getClass().getComponentType().getName();
        System.out.println(clazz);

        System.out.println(Array.getLength(arr));
//        String[] arr = new String[]{"1", "2"};
//
        arr = Arrays.copyOf(arr, 4);
//        System.out.println(arr.length);
    }

    @Test
    public void newInstance_test(){

//        Arrays.newInstance();
    }
}
