package study.jvm.jstatck;

/**
 * （1）wait时线程堆栈信息
 */
public class Wait2_Main {

    public static void main(String[] args) {
        Object lock = new Object();
        Thread t = new Thread(() -> {
            try {
                synchronized (lock) {
                    lock.wait(Long.MAX_VALUE);
                }
            } catch (InterruptedException ex) {
            }
        }, "t");
        t.start();
    }
}
/*
"t" #11 prio=5 os_prio=0 tid=0x000000001b46c800 nid=0x32dc in Object.wait() [0x000000001bdcf000]
        java.lang.Thread.State: TIMED_WAITING (on object monitor)
        at java.lang.Object.wait(Native Method)
        - waiting on <0x00000000d714a160> (a java.lang.Object)
        at study.jvm.jstatck.Wait2_Main.lambda$main$0(Wait2_Main.java:13)
        - locked <0x00000000d714a160> (a java.lang.Object)
        at study.jvm.jstatck.Wait2_Main$$Lambda$1/1607521710.run(Unknown Source)
        at java.lang.Thread.run(Thread.java:745)
*/
