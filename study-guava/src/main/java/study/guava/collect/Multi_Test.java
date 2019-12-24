package study.guava.collect;

import com.google.common.collect.*;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Multi_Test {

    //Multimap key -> Collection
    @Test
    public void Multimap_test() {
        Multimap<String, String> map = ArrayListMultimap.create();
        map.put("1", "aaa");
        map.put("1", "bbb");
        map.put("1", "ccc");

        for(String str :map.keySet()){
            System.out.println(str);
        }

        for(String key : map.keySet()){
            System.out.println(map.get(key));
        }
//        Collection<String> c = map.get("1");
//        System.out.println(c);
    }

    //Multiset
    @Test
    public void Multiset_test() {
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("a");
        multiset.add("b");
        Iterator<String> it = multiset.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(multiset.count("a"));
    }
}
