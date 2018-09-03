package study.jdk;

import org.junit.Test;

/**
 * 对象传递（数组、类、接口）是引用传递
 * 原始类型数据（整型、浮点型、字符型、布尔型）传递是值传递
 */
public class CallTest {

    @Test
    public void test1() {
        int num1 = 10;
        int num2 = 20;
        swap(num1, num2);
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
    }

    void swap(int a, int b) {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    @Test
    public void test2() {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(arr[0]);
        change(arr);
        System.out.println(arr[0]);
    }

    void change(int[] array) {
        //将数组的第一个元素变为0
        array[0] = 0;
    }

    @Test
    public void test3() {
        StringBuffer str = new StringBuffer("公众号：Java面试通关手册");
        System.out.println(str);
        change1(str);
        System.out.println(str);
    }

    void change1(StringBuffer str) {
        str = new StringBuffer("abc");
        //str.append("欢迎关注");
    }

    @Test
    public void test4() {
        String str = new String("公众号：Java面试通关手册");
        System.out.println(str);
        change2(str);
        System.out.println(str);
    }

    void change2(String str) {
        str = str + "abc";
    }
}
