package study.jdk.jcf;

import org.junit.Test;

public class HashMapTest {

    @Test
    public void sort_test() {
        //v << n, v左移n
        System.out.println(1 << 0); //1
        System.out.println(1 << 1); //2
        System.out.println(1 << 2); //4

        //v >> n, v右移n
        System.out.println(4 >> 1); //2
        System.out.println(4 >> 2); //1
        System.out.println(4 >> 3); //0
        System.out.println(4 >> 5); //0
    }

    @Test
    public void hash_test() {

    }
}
