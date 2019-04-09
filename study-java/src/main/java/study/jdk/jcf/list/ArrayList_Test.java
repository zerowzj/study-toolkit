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
    public void test_incr_decr() {
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
        ArrayList<String> dataLt = new ArrayList<>();
        //列表尾部插入元素
        dataLt.add("a");
        dataLt.add("b");
        LOGGER.info("{}", dataLt);
        //列表尾部插入元素列表
        dataLt.addAll(Arrays.asList("2", "3"));
        LOGGER.info("{}", dataLt);
        //指定位置插入指定元素，原来元素后移
        dataLt.add(0, "aa");
        LOGGER.info("{}", dataLt);
        //指定位置插入指定元素列表，原来元素后移
        dataLt.addAll(1, Arrays.asList("4", "5"));
        LOGGER.info("{}", dataLt);
    }

    /**
     * 演示：元素大小
     */
    @Test
    public void test_size() {
        List<String> dataLt = Arrays.asList("a", "b", "c");
        LOGGER.info("{}", dataLt.size());
    }

    /**
     * 演示：替换元素
     */
    @Test
    public void test_set() {
        List<String> dataLt = Arrays.asList("a", "b");
        //
        dataLt.set(0, "c");
        LOGGER.info("{}", dataLt);
    }

    /**
     * 演示：移除元素
     * （1）使用equal()判断
     */
    @Test
    public void test_remove() {
        List<String> dataLt = Arrays.asList("a", "b", "c", "d");
        //
        dataLt.remove("a");
        LOGGER.info("data={}", dataLt);
        //
        dataLt.remove(0);
        LOGGER.info("data={}", dataLt);
        //
        dataLt.removeAll(Arrays.asList("c", "b"));
        LOGGER.info("data={}", dataLt);
    }

    /**
     * 演示：获取元素
     */
    @Test
    public void get_test() {
        List<String> dataLt = Arrays.asList("a", "b", "c");
        LOGGER.info(dataLt.get(2));
    }

    /**
     * 演示：获取元素位置
     */
    @Test
    public void test_indexOf() {
        List<String> dataLt = Arrays.asList("a", "b", "c", "d");
        LOGGER.info("{}", dataLt.indexOf("b"));
        LOGGER.info("{}", dataLt.indexOf("e"));
    }

    /**
     * 演示：转换数组
     */
    @Test
    public void test_toArray() {
        List<String> dataLt = Arrays.asList("a", "b", "c", "d");
        //
        Object[] data1 = dataLt.toArray();
        LOGGER.info("data1={}", Arrays.toString(data1));
        //
        String[] data2 = dataLt.toArray(new String[]{});
        LOGGER.info("data2={}", Arrays.toString(data2));
    }

    /**
     * 演示：包含元素
     */
    @Test
    public void contains_test() {
        List<User> userLt = Arrays.asList(new User("1"), new User("2"));

        LOGGER.info("{}", userLt.contains(new User("1")));
        LOGGER.info("{}", userLt.containsAll(Arrays.asList(new User("1"), new User("6"))));
    }
}
