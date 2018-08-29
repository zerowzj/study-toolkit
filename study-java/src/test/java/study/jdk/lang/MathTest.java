package study.jdk.lang;

import org.junit.Test;

public class MathTest {

    @Test
    public void min_test(){
       int i = 100;
       int j = 102;
       System.out.println(Math.min(i, j));
    }

    @Test
    public void max_test(){
        int i = 100;
        int j = 102;
        System.out.println(Math.max(i, j));
    }

    public void test(){
    }
}
