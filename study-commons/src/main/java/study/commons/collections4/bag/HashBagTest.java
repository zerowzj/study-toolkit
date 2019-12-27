package study.commons.collections4.bag;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.junit.Test;

@Slf4j
public class HashBagTest {

    @Test
    public void test() {
        HashBag bag = new HashBag();
        bag.add("a", 5);
        bag.add("a");
        bag.add("b");
        bag.add("c");
        log.info("{}", bag.getCount("a"));
    }
}
