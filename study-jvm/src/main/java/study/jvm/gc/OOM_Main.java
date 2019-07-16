package study.jvm.gc;

import java.util.ArrayList;
import java.util.List;

public class OOM_Main {

    public static void main(String[] args) {
        List data = new ArrayList<>();
        while (true) {
            Byte[] bytes = new Byte[1024 * 1024];
            data.add(bytes);
            System.gc();
        }
    }
}
