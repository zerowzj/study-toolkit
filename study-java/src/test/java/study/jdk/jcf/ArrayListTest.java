package study.jdk.jcf;

import org.junit.Test;

import java.util.ArrayList;

public class ArrayListTest {

    @Test
    public void test() {
        int i = 0;
        System.out.println("    i=" + i);
        System.out.println("(++i)=" + (++i));
        System.out.println("    i=" + i);

        int a = 0;
        System.out.println("    a=" + a);
        System.out.println("(a++)=" + (a++));
        System.out.println("    a=" + a);
    }

    //
    @Test
    public void add_test() {
        ArrayList<String> lt = new ArrayList<>();
        lt.add("abc");
        lt.add("123");

//        lt.add(1, "abc");
    }
}
