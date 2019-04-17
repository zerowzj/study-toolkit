package study.guava.collect;

import com.google.common.collect.Lists;
import org.junit.Test;

public class ListsTest {

    @Test
    public void newArrayList_test() {
        Lists.newArrayList();
        Lists.newArrayList("", "");
        Lists.newLinkedList();
    }

    //
    @Test
    public void asList_test() {
        String[] strs = new String[]{"", ""};
        Lists.asList("", strs);
    }

    public void _test(){

    }
}
