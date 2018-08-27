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

    @Test
    public void test_reverse1() {
        String str = "abcd";
        String reverse = "";
        for (int i = 0; i < str.length(); i++) {
           // reverse = reverse + str.charAt(i);
            reverse = str.charAt(i) + reverse;
        }
        System.out.print(reverse);
    }

    @Test
    public void test_reverse2() {
        String str = "abcdefgh";
        String reverse = "";
        char[] arr = str.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            reverse = reverse + arr[i];
        }
        System.out.println(reverse);
    }
}
