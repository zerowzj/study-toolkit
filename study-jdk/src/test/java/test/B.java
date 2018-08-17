package test;

public class B extends A{



    {
        System.out.println("Instance init B.");
    }

    B() {
        System.out.println("Constructor B.");
    }

    static {
        System.out.println("Static init B.");
    }
}
