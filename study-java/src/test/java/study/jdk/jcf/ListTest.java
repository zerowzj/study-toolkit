package study.jdk.jcf;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        List<String> lt = new ArrayList<>();
        lt.add("1");
        lt.add("2");
    }

    //
    @Test
    public static void ArrayList_test() {
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
