package study.bytecode;

public class ByteCodeMain {

    public static void main(String[] args) {

    }

    public synchronized void method1() {
    }

    public void method2() {
        synchronized (this) {

        }
    }
}
