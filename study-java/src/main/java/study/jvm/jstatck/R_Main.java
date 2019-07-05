package study.jvm.jstatck;

public class R_Main {

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
