package study.jvm.jstatck;

/**
 * （1）wait时线程堆栈信息
 */
public class Wait1_Main {

    public static void main(String[] args) {
        Object lock = new Object();
        Thread t = new Thread(() -> {
            try {
                synchronized (lock) {
                    lock.wait();
                }
            } catch (InterruptedException ex) {
            }
        }, "t");
        t.start();
    }
}
/*
"t" #11 prio=5 os_prio=0 tid=0x000000001b87d000 nid=0x3580 in Object.wait() [0x000000001c16f000]
        java.lang.Thread.State: WAITING (on object monitor)
        at java.lang.Object.wait(Native Method)
        - waiting on <0x00000000d7149fd8> (a java.lang.Object)
        at java.lang.Object.wait(Object.java:502)
        at study.jvm.jstatck.Wait1_Main.lambda$main$0(Wait1_Main.java:13)
        - locked <0x00000000d7149fd8> (a java.lang.Object)
        at study.jvm.jstatck.Wait1_Main$$Lambda$1/1607521710.run(Unknown Source)
        at java.lang.Thread.run(Thread.java:745)
*/
