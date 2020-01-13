package study.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class LoadingCacheTest {

    LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder()
            .build(
                    new CacheLoader<String, String>() {
                        public String load(String key) {
                            return null;
                        }
                    });
}
