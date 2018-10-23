package study.jdk.jcf.list;

import org.junit.Test;
import study.jdk.jcf.User;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayList_Test {

    private ArrayList<String> lt = new ArrayList();

    /**
     * 输出结果：
     * i=0
     * (++i)=1
     * i=1
     * a=0
     * (a++)=0
     * a=1
     */
    @Test
    public void test() {
//        int i = 0;
//        System.out.println("    i=" + i);
//        System.out.println("(++i)=" + (++i));
//        System.out.println("    i=" + i);
//
//        int a = 0;
//        System.out.println("    a=" + a);
//        System.out.println("(a++)=" + (a++));
//        System.out.println("    a=" + a);

        Integer aa = null;
        Long bb = null;
        System.out.println(aa == null ? bb : aa);
    }

    /**
     * 输出结果：
     * 10
     * 1
     */
    @Test
    public void test_math() {
        System.out.println("max=" + Math.max(10, 1));
        System.out.println("min=" + Math.min(10, 1));
    }

    @Test
    public void add_test() {
        lt.add("a");
        lt.add("b");
        System.out.println(lt);

        lt.add(0, "1");
        System.out.println(lt);

        lt.addAll(Arrays.asList("2", "3"));
        System.out.println(lt);

        lt.addAll(0, Arrays.asList("4", "5"));
        System.out.println(lt);
    }

    @Test
    public void get_test() {
        add_test();
        System.out.println(lt.get(3));
    }

    @Test
    public void contains_test() {
        add_test();
        System.out.println(lt.contains("a"));

        ArrayList<User> ult = new ArrayList();
        ult.add(new User("1"));
        ult.add(new User("2"));

        System.out.println(ult.contains(new User("1")));
    }
}
