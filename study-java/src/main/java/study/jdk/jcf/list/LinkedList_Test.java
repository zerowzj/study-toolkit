package study.jdk.jcf.list;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

public class LinkedList_Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(LinkedList_Test.class);

    @Test
    public void test_add() {
        LinkedList<String> dataLt = new LinkedList();
        //linkLast()
        //（1）获取last节点
        //（2）生成新节点
        //（3）last节点为新节点
        dataLt.add("a");
        dataLt.add("b");

        dataLt.add(0, "a");
    }

    @Test
    public void test_get() {
        //
        int size = 8;
        LOGGER.info("{}", size >> 1);

    }
}
