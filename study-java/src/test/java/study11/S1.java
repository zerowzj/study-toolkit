package study11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class S1 extends F {

    protected static ExecutorService POOL = Executors.newFixedThreadPool(100);
}
