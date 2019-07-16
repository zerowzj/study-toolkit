package study.jvm.jstatck;

/**
 * （1）RUNNABLE时线程堆栈信息
 */
public class Runnable_Main {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                int a, b, c;
                a = 1;
                b = 2;
                c = a + b;
            }
        }, "t");
        t.start();
    }
}
/*
"t" #11 prio=5 os_prio=0 tid=0x000000001ad82800 nid=0x21d4 runnable [0x000000001b6df000]
        java.lang.Thread.State: RUNNABLE
        at study.study.jvm.jstatck.Runnable_Main.lambda$main$0(Runnable_Main.java:15)
        at study.study.jvm.jstatck.Runnable_Main$$Lambda$1/764977973.run(Unknown Source)
        at java.lang.Thread.run(Thread.java:745)
*/
