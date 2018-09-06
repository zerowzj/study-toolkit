package study.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆
 * -Xms10M -Xmx10M -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    static class OOMObject {
    }

    static List<OOMObject> LIST = new ArrayList();

    public static void main(String[] args) {
        while(true){
            LIST.add(new OOMObject());
        }
    }
}
