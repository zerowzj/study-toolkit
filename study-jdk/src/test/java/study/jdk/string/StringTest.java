package study.jdk.string;

import org.junit.Test;

public class StringTest {

    //编译器常量
    @Test
    public void test() {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = "a" + new String("bc");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
    }
}
