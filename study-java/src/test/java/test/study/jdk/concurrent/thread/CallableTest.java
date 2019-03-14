package test.study.jdk.concurrent.thread;

import org.junit.Test;

import java.util.concurrent.Callable;

public class CallableTest {

    @Test
    public void test() {

    }

    class MyTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            return null;
        }
    }
}
