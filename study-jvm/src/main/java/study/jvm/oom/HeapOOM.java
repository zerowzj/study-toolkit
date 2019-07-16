package study.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms5m -Xmx5m
 * -XX:+HeapDumpOnOutOfMemoryError
 * -XX:+PrintGC
 * -XX:+PrintGCDetails
 * -XX:+PrintGCTimeStamps
 * -XX:+PrintGCDateStamps
 */
public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
