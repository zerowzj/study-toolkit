package study.jvm.jstatck;

/**
 * （1）join时线程堆栈信息
 */
public class Join1_Main {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Sleeps.deep();
        }, "t");
        t.start();

        try {
            t.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
/*
"t" #11 prio=5 os_prio=0 tid=0x000000001aeb4800 nid=0xc78 waiting on condition [0x000000001bfce000]
        java.lang.Thread.State: TIMED_WAITING (sleeping)
        at java.lang.Thread.sleep(Native Method)
        at java.lang.Thread.sleep(Thread.java:340)
        at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
        at study.Sleeps.seconds(Sleeps.java:13)
        at study.Sleeps.deep(Sleeps.java:8)
        at study.study.jvm.jstatck.Join1_Main.lambda$main$0(Join1_Main.java:12)
        at study.study.jvm.jstatck.Join1_Main$$Lambda$1/764977973.run(Unknown Source)
        at java.lang.Thread.run(Thread.java:745)
*/
/*
"main" #1 prio=5 os_prio=0 tid=0x0000000004d22800 nid=0x35e0 in Object.wait() [0x0000000004b3f000]
        java.lang.Thread.State: WAITING (on object monitor)
        at java.lang.Object.wait(Native Method)
        - waiting on <0x00000000d7149ca0> (a java.lang.Thread)
        at java.lang.Thread.join(Thread.java:1249)
        - locked <0x00000000d7149ca0> (a java.lang.Thread)
        at java.lang.Thread.join(Thread.java:1323)
        at study.study.jvm.jstatck.Join1_Main.main(Join1_Main.java:17)
*/
