package study.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class CacheTest {

    Cache<String, String> cache = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .build();
}
