package study.jvm.jstatck;

import study.Sleeps;

/**
 * （1）join时线程堆栈信息
 */
public class Join2_Main {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Sleeps.deep();
        }, "t");
        t.start();

        try {
            t.join(Long.MAX_VALUE);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
/*
"t" #11 prio=5 os_prio=0 tid=0x000000001b135800 nid=0x3680 waiting on condition [0x000000001ba1e000]
        java.lang.Thread.State: TIMED_WAITING (sleeping)
        at java.lang.Thread.sleep(Native Method)
        at java.lang.Thread.sleep(Thread.java:340)
        at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
        at study.Sleeps.seconds(Sleeps.java:13)
        at study.Sleeps.deep(Sleeps.java:8)
        at study.jvm.jstatck.Join2_Main.lambda$main$0(Join2_Main.java:9)
        at study.jvm.jstatck.Join2_Main$$Lambda$1/764977973.run(Unknown Source)
        at java.lang.Thread.run(Thread.java:745)
*/
/*
"main" #1 prio=5 os_prio=0 tid=0x0000000004722800 nid=0x220c in Object.wait() [0x000000000457f000]
        java.lang.Thread.State: TIMED_WAITING (on object monitor)
        at java.lang.Object.wait(Native Method)
        - waiting on <0x00000000d7149c28> (a java.lang.Thread)
        at java.lang.Thread.join(Thread.java:1257)
        - locked <0x00000000d7149c28> (a java.lang.Thread)
        at study.jvm.jstatck.Join2_Main.main(Join2_Main.java:14)
*/
