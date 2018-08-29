package study.jdk.jcf;

import org.junit.Test;

import java.util.LinkedList;

public class LinkedListTest {

    @Test
    public void add_test() {
        LinkedList<String> lt = new LinkedList();

        lt.add("abc");
        lt.add("123");
    }
}
