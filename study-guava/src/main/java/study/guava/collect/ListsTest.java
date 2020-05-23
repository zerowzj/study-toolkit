package study.guava.collect;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void _test(){
        List<String> dataLt = Lists.newArrayList("1", "2", "3","4", "5", "6");
        List<List<String>> data = Lists.partition(dataLt, 3);
        Lists.p
        System.out.println(data);
    }
}
