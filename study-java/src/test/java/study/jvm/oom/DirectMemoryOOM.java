package study.jvm.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 直接内存
 * -Xms20M -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {

    private static final int _1M = 1024 * 1024;

    public static void main(final String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);

        while (true) {
            unsafe.allocateMemory(_1M);
        }
    }
}
