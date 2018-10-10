package study.jdk.exception;

import study.Sleeps;

public class ForExceptionMain {

    public static void main(String[] args) {
//        test1();
//        test2();

        int i = 0;
        for (; ; ) {
            try {
                Sleeps.milliseconds(500);
                i++;
                System.out.println("==>" + i);
                if (i == 10) {
                    throw new NullPointerException();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void test1() {
        print();
    }

    private static void test2() {
        try {
            print();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void print() {
        int i = 0;
        for (; ; ) {
            i++;
            System.out.println("==>" + i);
            if (i == 10) {
                throw new NullPointerException();
            }
        }
    }
}
