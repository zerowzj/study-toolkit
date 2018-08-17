package test;

public class C extends B {

    static {
        System.out.println("Static init C.");
    }

    {
        System.out.println("Instance init C.");
    }

    C() {
        System.out.println("Constructor C.");
    }

    public static void main(String[] args) {
        C c = new C();
    }
}
