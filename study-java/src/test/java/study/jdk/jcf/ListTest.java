package study.jdk.jcf;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    //
    @Test
    public void ArrayList_test() {
        List<String> lt = Arrays.asList("123", "abc");
        lt.forEach(str -> {
            if("123".equals(str)){
                return;
            }
            System.out.println(str);
        });

        new ArrayList<>();

    }

    //
    @Test
    public void LinkedList_test() {

        new LinkedList<>();

    }
}
