package study.jvm;

import java.util.concurrent.TimeUnit;

public class DeadLoopMain {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true){
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("tttt");
                    }
                } catch (Exception ex) {

                }
            }
        }, "My-Thread-1");
        t.start();

        for (; ; ) {
            System.out.println("aaaa");
        }
    }
}
