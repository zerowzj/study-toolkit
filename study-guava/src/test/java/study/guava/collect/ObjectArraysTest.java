package study.guava.collect;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ObjectArrays;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObjectArraysTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectArraysTest.class);

    @Test
    public void test() {
        String[] strs = new String[]{};
        for (int i = 0; i < 5; i++) {
            strs = ObjectArrays.concat(strs, String.valueOf(i));
        }
        LOGGER.info("{}", Joiner.on(",").join(strs));
        System.out.println(strs);
        for(String str : strs){
            System.out.println(str);
        }
    }
}
