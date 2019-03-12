package test.study.jdk;

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
        change2(arr);
        System.out.println(arr[0]);
    }

    void change2(int[] array) {
        //将数组的第一个元素变为0
        array[0] = 0;
    }

    @Test
    public void test3() {
        StringBuffer str = new StringBuffer("公众号：Java面试通关手册");
        System.out.println(str);
        change3(str);
        System.out.println(str);
    }

    void change3(StringBuffer str) {
        str = new StringBuffer("abc");
        //str.append("欢迎关注");
    }

    @Test
    public void test4() {
        String str = new String("公众号：Java面试通关手册");
        System.out.println(str);
        change4(str);
        System.out.println(str);
    }

    void change4(String str) {
        str = str + "abc";
    }

    @Test
    public void test5() {
        Person p = new Person("张三");
        chang5(p);
        System.out.println(p.name);
    }

    void chang5(Person p) {
        p.name = "李四";
//        Person person = new Person("李四");
//        p = person;
    }

    class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }
    }

}
