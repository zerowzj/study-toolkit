package study.jdk.jcf.list;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.jdk.jcf.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayList_Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayList_Test.class);

    /**
     * 演示：自增自减操作
     */
    @Test
    public void test_incrAnddecr() {
        int a = 0;
        LOGGER.info("    a={}", a);
        LOGGER.info("(++a)={}", (++a));
        LOGGER.info("    a={}", a);

        int b = 0;
        LOGGER.info("    b={}", b);
        LOGGER.info("(b++)={}", (b++));
        LOGGER.info("    b={}", b);
    }

    /**
     * 演示：添加元素
     */
    @Test
    public void test_add() {
        ArrayList<String> data = new ArrayList<>();
        //列表尾部插入元素
        data.add("a");
        data.add("b");
        LOGGER.info("{}", data);
        //列表尾部插入元素列表
        data.addAll(Arrays.asList("2", "3"));
        LOGGER.info("{}", data);
        //指定位置插入指定元素，原来元素后移
        data.add(0, "aa");
        LOGGER.info("{}", data);
        //指定位置插入指定元素列表，原来元素后移
        data.addAll(1, Arrays.asList("4", "5"));
        LOGGER.info("{}", data);
    }

    /**
     * 演示：获取元素
     */
    @Test
    public void get_test() {
        List<String> data = Arrays.asList("a", "b", "c");
        LOGGER.info(data.get(2));
    }

    /**
     * 演示：包含元素
     */
    @Test
    public void contains_test() {
        List<String> lt = new ArrayList<>();
        System.out.println(lt.contains("a"));

        ArrayList<User> ult = new ArrayList();
        ult.add(new User("1"));
        ult.add(new User("2"));

        System.out.println(ult.contains(new User("1")));
    }
}
