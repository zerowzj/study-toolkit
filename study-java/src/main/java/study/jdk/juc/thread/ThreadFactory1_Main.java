package study.jdk.juc.thread;

import java.util.concurrent.ThreadFactory;

public class ThreadFactory1_Main {

    class MyThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r);
        }
    }

    public static void main(String[] args) {
        ThreadFactory f;
    }
}
