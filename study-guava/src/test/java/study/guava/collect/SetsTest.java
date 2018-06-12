package study.guava.collect;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

public class SetsTest {

    @Test
    public void newArrayList_test() {
    }

    //
    @Test
    public void asList_test() {
        String[] strs = new String[]{"", ""};
        Lists.asList("", strs);
    }
}
