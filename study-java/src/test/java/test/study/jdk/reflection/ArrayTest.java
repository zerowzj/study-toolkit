package test.study.jdk.reflection;

import org.junit.Test;

import java.lang.reflect.Array;

public class ArrayTest {

    @Test
    public void newInstance_test(){
        String[] arr = (String[])Array.newInstance(String.class, 8);
        System.out.println(arr.length);
    }

    @Test
    public void get_test(){
        String[] arr = new String[]{"a", "b", "c", "d"};
        System.out.println(Array.get(arr, 5));
    }
}
