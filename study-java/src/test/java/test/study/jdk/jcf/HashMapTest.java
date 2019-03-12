package test.study.jdk.jcf;

import org.junit.Test;

public class HashMapTest {

    @Test
    public void move_test() {
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

    /**
     * 只有两个操作数对应位同为1时，结果为1，其余全为0.
     * （或者是只要有一个操作数为0，结果就为0）。
     */
    @Test
    public void bit_and_test() {
        System.out.println(0 & 0);
    }
    /**
     * 只有两个操作数对应位同为0时，结果为0，其余全为1.
     * （或者是只要有一个操作数为1，结果就为1）。
     */
    @Test
    public void bit_or_test() {
        System.out.println(0 & 0);
    }

    @Test
    public void bit_not_test() {
        System.out.println(0 & 0);
    }

    @Test
    public void hash_test() {

    }
}
