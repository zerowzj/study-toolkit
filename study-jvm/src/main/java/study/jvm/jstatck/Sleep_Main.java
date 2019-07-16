package study.jvm.jstatck;

import java.util.concurrent.TimeUnit;

/**
 * （1）sleep时线程堆栈信息
 */
public class Sleep_Main {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(Long.MAX_VALUE);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }, "t");
        t.start();
    }
}
/*
"t" #11 prio=5 os_prio=0 tid=0x000000001b3f2800 nid=0x235c waiting on condition [0x000000001bccf000]
        java.lang.Thread.State: TIMED_WAITING (sleeping)
        at java.lang.Thread.sleep(Native Method)
        at java.lang.Thread.sleep(Thread.java:340)
        at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
        at study.study.jvm.jstatck.Sleep_Main.lambda$main$0(Sleep_Main.java:13)
        at study.study.jvm.jstatck.Sleep_Main$$Lambda$1/764977973.run(Unknown Source)
        at java.lang.Thread.run(Thread.java:745)
*/
