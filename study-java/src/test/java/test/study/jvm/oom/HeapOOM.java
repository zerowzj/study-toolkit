package test.study.jvm.oom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 堆
 * -Xms10M -Xmx10M -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    static class OOMObject {
    }

    static List<OOMObject> LIST = new ArrayList();

    public static void main(String[] args) throws Exception{
        while(true){
            LIST.add(new OOMObject());
            //TimeUnit.MILLISECONDS.sleep(1);
        }
    }
}
