package test;

public class Main {

    static {
        System.out.println("Static init Main.");
    }

    {
        System.out.println("Instance init Main.");
    }

    Main() {
        System.out.println("Constructor Main.");
    }

    public static void main(String[] args) {
//        C c = new C();
        System.out.println("+++++++++++=");
        B b = new B();
    }
}
