package study.jdk.jcf;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {

    ArrayList<String> lt = new ArrayList();

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
    public void get_test(){
        add_test();
        System.out.println(lt.get(3));
    }

    @Test
    public void contains_test(){
        add_test();
        System.out.println(lt.contains("a"));

        ArrayList<User> ult = new ArrayList();
        ult.add(new User("1"));
        ult.add(new User("2"));

        System.out.println(ult.contains(new User("1")));
    }

}
