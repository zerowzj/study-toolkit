package test.study;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class S2 extends F {

    protected static ExecutorService POOL = Executors.newFixedThreadPool(100);

    public static void main(String[] args) {
        System.out.println(S1.F_POOL == S2.F_POOL);
        System.out.println(S1.POOL == S2.POOL);
    }
}
