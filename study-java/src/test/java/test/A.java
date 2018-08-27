package test;

public class A {
    static {
        System.out.println("Static init A.");
    }

    {
        System.out.println("Instance init A.");
    }

    A() {
        System.out.println("Constructor A.");
    }
}
